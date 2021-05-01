package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import transport.Transport;
import transport.water.Ship;

public class ShipViewModel implements ViewModel {
    public static ShipViewModel create() {
        return Main.create("ship.fxml");
    }

    @FXML
    private GridPane root;
    @FXML
    private TextField width, height, depth, maxSpeed, teamCount, passagesCount,
            minDisplacement, maxDisplacement, sailingRange;

    private Main m;
    private Ship v;

    private void setDisable() {
        getRoot().setDisable(v == null || m == null);
    }

    public GridPane getRoot() {
        return root;
    }

    public Main getMain() {
        return m;
    }
    public void setMain(Main m) {
        this.m = m;
        setDisable();
    }

    public Transport getTransport() {
        return v;
    }
    public void setTransport(Transport t) {
        v = ((Ship) t);
        setDisable();
        if (v == null)
            return;
        width.setText(String.valueOf(v.getWidth()));
        height.setText(String.valueOf(v.getHeight()));
        depth.setText(String.valueOf(v.getDepth()));
        maxSpeed.setText(String.valueOf(v.getMaxSpeed()));
        teamCount.setText(String.valueOf(v.getTeamCount()));
        passagesCount.setText(String.valueOf(v.getPassagesCount()));
        minDisplacement.setText(String.valueOf(v.getMinDisplacement()));
        maxDisplacement.setText(String.valueOf(v.getMaxDisplacement()));
        sailingRange.setText(String.valueOf(v.getSailingRange()));
    }

    @FXML
    private void initialize() {
        setOnEnterIntSetter(width, width1 -> v.setWidth(width1));
        setOnEnterIntSetter(height, height1 -> v.setHeight(height1));
        setOnEnterIntSetter(depth, depth1 -> v.setDepth(depth1));
        setOnEnterIntSetter(maxSpeed, maxSpeed1 -> v.setMaxSpeed(maxSpeed1));
        setOnEnterIntSetter(teamCount, teamCount1 -> v.setTeamCount(teamCount1));
        setOnEnterIntSetter(passagesCount, passagesCount1 -> v.setPassagesCount(passagesCount1));
        setOnEnterIntSetter(minDisplacement, minDisplacement1 -> v.setMinDisplacement(minDisplacement1));
        setOnEnterIntSetter(maxDisplacement, maxDisplacement1 -> v.setMaxDisplacement(maxDisplacement1));
        setOnEnterIntSetter(sailingRange, sailingRange1 -> v.setSailingRange(sailingRange1));
    }
}