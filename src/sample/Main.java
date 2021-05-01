package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.util.StringConverter;
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

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Supplier;

public class Main implements Controller {
    public static <T> T create(String s) {
        FXMLLoader l = new FXMLLoader();
        try {
            l.load(Main.class.getResourceAsStream(s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return l.getController();
    }

    public static void completeAlert(String message, Alert.AlertType type) {
        alert("Complete!", message, "", type);
    }
    public static void errorAlert(String message) {
        alert("Error", message, "An error occurred during execution.", Alert.AlertType.ERROR);
    }
    public static void alert(String title, String message, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(message);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private HBox root;
    @FXML
    private ListView<Transport> listView;
    @FXML
    private ChoiceBox<Supplier<Transport>> transportCB;
    @FXML
    private ChoiceBox<Serializer> serialCB;

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

    public Pane getRoot() {
        return root;
    }
    public void refresh() {
        listView.refresh();
    }
    public void handle(Exception e) {
        errorAlert(e.toString());
    }

    @FXML
    private void add() {
        list.add(transportCB.getValue().get());
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
        try {
            list.addAll(serialCB.getValue().load(file));
        } catch (Exception e) {
            handle(e);
        }
    }
    @FXML
    private void save() {
        File file = chooser.showSaveDialog(null);
        if (file == null)
            return;
        ObservableList<Transport> ts = list;//listView.getSelectionModel().getSelectedItems();
        if (ts.isEmpty())
            return;
        try {
            serialCB.getValue().save(file, ts);
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
        for (ViewModel model : map.values())
            model.setMain(this);

        ViewModel model = map.values().iterator().next();
        active = model;
        getRoot().getChildren().add(model.getRoot());


        ObservableList<Serializer> serializers = FXCollections.observableArrayList(
                new JavaSerializer(),
                new XMLSerializer()
        );
        serialCB.setConverter(new StringConverter<>() {
            final String[] names = {
                    "JavaSerializer",
                    "XMLSerializer",
            };

            public String toString(Serializer fa) {
                for (int i = 0; i < serializers.size(); i++)
                    if (serializers.get(i).equals(fa))
                        return names[i];
                return null;
            }

            public Serializer fromString(String s) {
                for (int i = 0; i < names.length; i++)
                    if (names[i].equals(s))
                        return serializers.get(i);
                return null;
            }
        });
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
        transportCB.setConverter(new StringConverter<>() {
            final String[] names = {
                    "Plane",
                    "Helicopter",
                    "Auto",
                    "MotorCycle",
                    "Train",
                    "Ship",
                    "Submarine"
            };

            public String toString(Supplier<Transport> fa) {
                for (int i = 0; i < factories.size(); i++)
                    if (factories.get(i).equals(fa))
                        return names[i];
                return null;
            }

            public Supplier<Transport> fromString(String s) {
                for (int i = 0; i < names.length; i++)
                    if (names[i].equals(s))
                        return factories.get(i);
                return null;
            }
        });
        transportCB.setItems(factories);
        transportCB.setValue(factories.get(0));

        for (Supplier<Transport> factory : factories)
            list.add(factory.get());
        listView.setItems(list);
        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, transportTransport, t1) ->
                setActive(listView.getSelectionModel().getSelectedItem()));
    }
}