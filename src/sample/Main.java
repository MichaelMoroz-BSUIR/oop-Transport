package sample;

import archiver.Huffman;
import cipher.Cipher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;
import sample.cipherViewModel.BitViewModel;
import sample.cipherViewModel.CipherViewModel;
import sample.cipherViewModel.RSAViewModel;
import sample.transportViewModel.*;
import serializer.JavaSerializer;
import serializer.Serializer;
import serializer.XMLSerializer;
import transport.Transport;
import transport.air.Helicopter;
import transport.air.Plane;
import transport.land.Auto;
import transport.land.MotorCycle;
import transport.land.Train;
import transport.water.Ship;
import transport.water.Submarine;

import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class Main implements Controller {
    public static Main create() {
        return App.create("fxml/main.fxml");
    }

    @FXML
    private HBox root;
    @FXML
    private ChoiceBox<Supplier<Transport>> transportCB;
    @FXML
    private ChoiceBox<Serializer> serialCB;
    @FXML
    private Accordion ciphers;
    @FXML
    private ListView<Transport> listView;

    private Map<Class<? extends Transport>, ViewModel> map;
    private final ObservableList<Transport> list = FXCollections.observableArrayList();
    private final FileChooser chooser = new FileChooser();

    private Controller active;

    private void setActive(Transport t) {
        ViewModel model = map.get(t.getClass());
        model.setTransport(t);

        ObservableList<Node> c = getRoot().getChildren();
        c.remove(active.getRoot());
        c.add(model.getRoot());
        active = model;
    }

    public void refresh() {
        listView.refresh();
    }
    public void handle(Exception e) {
        App.errorAlert(e.toString());
    }

    public Pane getRoot() {
        return root;
    }
    private Supplier<Transport> getTransportFactory() {
        return transportCB.getValue();
    }
    private Serializer getSerializer() {
        Serializer value = serialCB.getValue();
        Cipher cipher = getCipher();
        return cipher == null ? value :
                new CipherSerializer(value, cipher);
    }
    private Cipher getCipher() {
        TitledPane pane = ciphers.getExpandedPane();
        return pane == null ? null : ((CipherPane) pane).getCipherViewModel().get();
    }

    @FXML
    private void add() {
        list.add(getTransportFactory().get());
    }
    @FXML
    private void remove() {
        int i = listView.getSelectionModel().getSelectedIndex();
        if (i >= 0)
            list.remove(i);
    }

    @FXML
    private void load() {
        File file = chooser.showOpenDialog(null);
        if (file == null)
            return;
        try (InputStream in = new FileInputStream(file)) {
            list.addAll(getSerializer().load(in));
        } catch (Exception e) {
            handle(e);
        }
    }
    @FXML
    private void save() {
        File file = chooser.showSaveDialog(null);
        if (file == null)
            return;
        try (OutputStream out = new FileOutputStream(file)) {
            getSerializer().save(out, list);
        } catch (Exception e) {
            handle(e);
        }
    }

    @FXML
    private void initialize() {
        map = Map.of(
                Plane.class, PlaneViewModel.create(),
                Helicopter.class, HelicopterViewModel.create(),
                Auto.class, AutoViewModel.create(),
                MotorCycle.class, MotorCycleViewModel.create(),
                Train.class, TrainViewModel.create(),
                Ship.class, ShipViewModel.create(),
                Submarine.class, SubmarineViewModel.create()
        );

        ViewModel model = map.values().iterator().next();
        active = model;
        getRoot().getChildren().add(model.getRoot());


        ObservableList<TitledPane> panes = ciphers.getPanes();
        panes.add(new CipherPane("RSA Cipher", RSAViewModel.create()));
        panes.add(new CipherPane("Bit Cipher", BitViewModel.create()));


        ObservableList<Serializer> serializers = FXCollections.observableArrayList(
                new JavaSerializer(),
                new XMLSerializer()
        );
        serialCB.setConverter(new StrMap<>(serializers,
                "JavaSerializer",
                "XMLSerializer"));
        serialCB.setItems(serializers);
        serialCB.setValue(serializers.get(0));


        ObservableList<Supplier<Transport>> factories = FXCollections.observableArrayList(
                () -> new Plane(22690, 2360, 13460,
                        21820, 46750, 2500,
                        2, 0,
                        21500, 61),
                () -> new Helicopter(21000, 5000, 25000,
                        5726, 12000, 250,
                        3, 18,
                        5000, 21),
                () -> new Auto(4860, 1430, 1800,
                        195, 1, 3,
                        1530, 2040,
                        3.4, "Wolksvagen", "Back"),
                () -> new MotorCycle(2005, 1080, 849,
                        143, 1, 1,
                        164, 345,
                        7.8, "BMW"),
                () -> new Train(250_462, 4850, 3480,
                        160, 2, 346,
                        10),
                () -> new Ship(306450, 64490, 71960,
                        54, 1980, 0,
                        46540000, 61390000,
                        12359),
                () -> new Submarine(154000, 9200, 18200,
                        90, 40, 0,
                        14700000, 23900000,
                        520, 600, 27)
        );
        transportCB.setConverter(new StrMap<>(factories,
                "Plane",
                "Helicopter",
                "Auto",
                "MotorCycle",
                "Train",
                "Ship",
                "Submarine"));
        transportCB.setItems(factories);
        transportCB.setValue(factories.get(0));

        for (Supplier<Transport> factory : factories)
            list.add(factory.get());
        listView.setItems(list);
        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, transportTransport, t1) ->
                setActive(listView.getSelectionModel().getSelectedItem()));
    }
}

class StrMap<T> extends StringConverter<T> {
    private final List<T> list;
    private final String[] names;

    public StrMap(List<T> list, String... names) {
        this.list = Objects.requireNonNull(list);
        this.names = names;
    }

    public String toString(T t) {
        int i = list.indexOf(t);
        return i < 0 ? null : names[i];
    }
    public T fromString(String s) {
        for (int i = 0; i < names.length; i++)
            if (names[i].equals(s))
                return list.get(i);
        return null;
    }
}

class CipherPane extends TitledPane {
    private final CipherViewModel cipherViewModel;

    CipherPane(String title, CipherViewModel cipherViewModel) {
        this.cipherViewModel = Objects.requireNonNull(cipherViewModel);
        setContent(cipherViewModel.getRoot());
        setText(title);
    }

    public CipherViewModel getCipherViewModel() {
        return cipherViewModel;
    }
}

class CipherSerializer implements Serializer {
    private final Serializer back;
    private final Cipher cipher;

    public CipherSerializer(Serializer back, Cipher cipher) {
        this.back = Objects.requireNonNull(back);
        this.cipher = Objects.requireNonNull(cipher);
    }

    public void save(OutputStream out, Collection<? extends Transport> ts) throws Exception {
        back.save(cipher.encode(out), ts);
    }
    public Collection<? extends Transport> load(InputStream in) throws Exception {
        return back.load(cipher.decode(in));
    }
}