package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import transport.air.Plane;

public class PlaneViewModel implements ViewModel<Plane> {
    @FXML
    private GridPane root;
    @FXML
    private TextField width, height, depth, maxSpeed, teamCount, passagesCount,
            minWeight, maxWeight, maxFlightAltitude, wingArea;

    public GridPane getRoot() {
        return root;
    }

    public void bind(Plane p, Main m) {
        if (p == null || m == null)
            return;
        width.setText(String.valueOf(p.getWidth()));
        height.setText(String.valueOf(p.getHeight()));
        depth.setText(String.valueOf(p.getDepth()));
        maxSpeed.setText(String.valueOf(p.getMaxSpeed()));
        teamCount.setText(String.valueOf(p.getTeamCount()));
        passagesCount.setText(String.valueOf(p.getPassagesCount()));
        minWeight.setText(String.valueOf(p.getMinWeight()));
        maxWeight.setText(String.valueOf(p.getMaxWeight()));
        maxFlightAltitude.setText(String.valueOf(p.getMaxFlightAltitude()));
        wingArea.setText(String.valueOf(p.getWingArea()));

        ViewModel.setOnEnterIntSetter(width, p::setWidth, m);
        ViewModel.setOnEnterIntSetter(height, p::setHeight, m);
        ViewModel.setOnEnterIntSetter(depth, p::setDepth, m);
        ViewModel.setOnEnterIntSetter(maxSpeed, p::setMaxSpeed, m);
        ViewModel.setOnEnterIntSetter(teamCount, p::setTeamCount, m);
        ViewModel.setOnEnterIntSetter(passagesCount, p::setPassagesCount, m);
        ViewModel.setOnEnterIntSetter(minWeight, p::setMinWeight, m);
        ViewModel.setOnEnterIntSetter(maxWeight, p::setMaxWeight, m);
        ViewModel.setOnEnterIntSetter(maxFlightAltitude, p::setMaxFlightAltitude, m);
        ViewModel.setOnEnterIntSetter(wingArea, p::setWingArea, m);
    }

    public static PlaneViewModel create() {
        return Main.create("plane.fxml");
    }
}