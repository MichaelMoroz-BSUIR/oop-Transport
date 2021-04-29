package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import transport.Transport;
import transport.air.Helicopter;
import transport.air.Plane;
import transport.land.Auto;
import transport.land.MotorCycle;
import transport.land.Train;
import transport.water.Ship;
import transport.water.Submarine;

import java.io.IOException;
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

    private PlaneViewModel planeViewModel;
    private HelicopterViewModel helicopterViewModel;

    private AutoViewModel autoViewModel;
    private MotorCycleViewModel motorCycleViewModel;
    private TrainViewModel trainViewModel;

    private ShipViewModel shipViewModel;
    private SubmarineViewModel submarineViewModel;

    @FXML
    private HBox root;
    @FXML
    private ListView<Entry> listView;
    @FXML
    private ChoiceBox<Supplier<Entry>> choiceBox;

    private final ObservableList<Entry> list = FXCollections.observableArrayList();

    private Controller active;
    private void setActive(Entry t) {
        ObservableList<Node> c = getRoot().getChildren();
        c.remove(active.getRoot());
        active = t.getController();
        c.add(active.getRoot());
        t.bind(this);
    }

    public Pane getRoot() {
        return root;
    }
    public void handle(Exception e) {
        errorAlert(e.toString());
    }
    public void refresh() {
        listView.refresh();
    }

    @FXML
    private void add() {
        list.add(choiceBox.getValue().get());
    }
    @FXML
    private void remove() {
        try {
            int i = listView.getSelectionModel().getSelectedIndex();
            if (i > 0)
                list.remove(i);
        } catch (Exception ignored) {
        }
    }

    @FXML
    private void initialize() {
        planeViewModel = PlaneViewModel.create();
        helicopterViewModel = HelicopterViewModel.create();
        autoViewModel = AutoViewModel.create();
        motorCycleViewModel = MotorCycleViewModel.create();
        trainViewModel = TrainViewModel.create();
        shipViewModel = ShipViewModel.create();
        submarineViewModel = SubmarineViewModel.create();

        getRoot().getChildren().add(planeViewModel.getRoot());
        active = planeViewModel;

        String[] names = {
                "Plane",
                "Helicopter",
                "Auto",
                "MotorCycle",
                "Train",
                "Ship",
                "Submarine"
        };
        ObservableList<Supplier<Entry>> factories = FXCollections.observableArrayList(
                () -> new Entry() {
                    private final Plane plane = new Plane(22690, 0, 13460,
                            21820 , 46750 , 2500,
                            2, 0,
                            21500, 61);

                    public Transport getValue() {
                        return plane;
                    }

                    public Controller getController() {
                        return planeViewModel;
                    }

                    public void bind(Main main) {
                        planeViewModel.bind(plane, main);
                    }

                    public String toString() {
                        return getValue().toString();
                    }
                },
                () -> new Entry() {
                    private final Helicopter helicopter = new Helicopter(21000, 5000, 25000,
                            5726 , 12000, 250 ,
                            3, 18,
                            5000, 21);

                    public Transport getValue() {
                        return helicopter;
                    }

                    public Controller getController() {
                        return helicopterViewModel;
                    }

                    public void bind(Main main) {
                        helicopterViewModel.bind(helicopter, main);
                    }

                    public String toString() {
                        return getValue().toString();
                    }
                },
                () -> new Entry() {
                    private final Auto auto = new Auto(4860, 1430, 1800,
                            195, 1, 3,
                            1530, 2040,
                            3.4, "Wolksvagen", "Back");

                    public Transport getValue() {
                        return auto;
                    }

                    public Controller getController() {
                        return autoViewModel;
                    }

                    public void bind(Main main) {
                        autoViewModel.bind(auto, main);
                    }

                    public String toString() {
                        return getValue().toString();
                    }
                },
                () -> new Entry() {
                    private final MotorCycle cycle = new MotorCycle(2005, 1080, 849,
                            143, 1, 1,
                            164, 345,
                            7.8, "BMW");

                    public Transport getValue() {
                        return cycle;
                    }

                    public Controller getController() {
                        return motorCycleViewModel;
                    }

                    public void bind(Main main) {
                        motorCycleViewModel.bind(cycle, main);
                    }

                    public String toString() {
                        return getValue().toString();
                    }
                },
                () -> new Entry() {
                    private final Train train = new Train(0, 0, 0,
                            0, 0, 0,
                            0);

                    public Transport getValue() {
                        return train;
                    }

                    public Controller getController() {
                        return trainViewModel;
                    }

                    public void bind(Main main) {
                        trainViewModel.bind(train, main);
                    }

                    public String toString() {
                        return getValue().toString();
                    }
                },
                () -> new Entry() {
                    private final Ship ship = new Ship(306450, 64490, 71960,
                            54, 1980, 0,
                            46540000, 61390000,
                            12359);

                    public Transport getValue() {
                        return ship;
                    }

                    public Controller getController() {
                        return shipViewModel;
                    }

                    public void bind(Main main) {
                        shipViewModel.bind(ship, main);
                    }

                    public String toString() {
                        return getValue().toString();
                    }
                },
                () -> new Entry() {
                    private final Submarine submarine = new Submarine(154000, 9200, 18200,
                            90, 0, 0,
                            14700000, 23900000,
                            520, 600, 27);

                    public Transport getValue() {
                        return submarine;
                    }

                    public Controller getController() {
                        return submarineViewModel;
                    }

                    public void bind(Main main) {
                        submarineViewModel.bind(submarine, main);
                    }

                    public String toString() {
                        return getValue().toString();
                    }
                }
        );

        choiceBox.setItems(factories);
        choiceBox.setConverter(new StringConverter<>() {
            public String toString(Supplier<Entry> entrySupplier) {
                for (int i = 0; i < factories.size(); i++)
                    if (factories.get(i).equals(entrySupplier))
                        return names[i];
                return null;
            }

            public Supplier<Entry> fromString(String s) {
                for (int i = 0; i < names.length; i++)
                    if (names[i].equals(s))
                        return factories.get(i);
                return null;
            }
        });
        choiceBox.setValue(factories.get(0));

        listView.setItems(list);
        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, transportEntry, t1) ->
                setActive(listView.getSelectionModel().getSelectedItem()));
    }
}