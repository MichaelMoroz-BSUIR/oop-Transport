package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import transport.air.Helicopter;

public class HelicopterViewModel implements ViewModel<Helicopter> {
    @FXML
    private GridPane root;
    @FXML
    private TextField width, height, depth, maxSpeed, teamCount, passagesCount,
            minWeight, maxWeight, maxFlightAltitude, rotorDiameter;

    public GridPane getRoot() {
        return root;
    }

    public void bind(Helicopter h, Main m) {
        if (h == null || m == null)
            return;
        width.setText(String.valueOf(h.getWidth()));
        height.setText(String.valueOf(h.getHeight()));
        depth.setText(String.valueOf(h.getDepth()));
        maxSpeed.setText(String.valueOf(h.getMaxSpeed()));
        teamCount.setText(String.valueOf(h.getTeamCount()));
        passagesCount.setText(String.valueOf(h.getPassagesCount()));
        minWeight.setText(String.valueOf(h.getMinWeight()));
        maxWeight.setText(String.valueOf(h.getMaxWeight()));
        maxFlightAltitude.setText(String.valueOf(h.getMaxFlightAltitude()));
        rotorDiameter.setText(String.valueOf(h.getRotorDiameter()));

        ViewModel.setOnEnterIntSetter(width, h::setWidth, m);
        ViewModel.setOnEnterIntSetter(height, h::setHeight, m);
        ViewModel.setOnEnterIntSetter(depth, h::setDepth, m);
        ViewModel.setOnEnterIntSetter(maxSpeed, h::setMaxSpeed, m);
        ViewModel.setOnEnterIntSetter(teamCount, h::setTeamCount, m);
        ViewModel.setOnEnterIntSetter(passagesCount, h::setPassagesCount, m);
        ViewModel.setOnEnterIntSetter(minWeight, h::setMinWeight, m);
        ViewModel.setOnEnterIntSetter(maxWeight, h::setMaxWeight, m);
        ViewModel.setOnEnterIntSetter(maxFlightAltitude, h::setMaxFlightAltitude, m);
        ViewModel.setOnEnterIntSetter(rotorDiameter, h::setRotorDiameter, m);
    }

    public static HelicopterViewModel create() {
        return Main.create("helicopter.fxml");
    }
}