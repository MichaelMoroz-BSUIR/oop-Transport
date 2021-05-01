package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import transport.Transport;
import transport.land.Auto;

public class AutoViewModel implements ViewModel {
    public static AutoViewModel create() {
        return Main.create("auto.fxml");
    }

    @FXML
    private GridPane root;
    @FXML
    private TextField width, height, depth, maxSpeed, teamCount, passagesCount,
            minWeight, maxWeight, accelerationTimeTo100, mark, transmissionType;

    private Main m;
    private Auto a;

    private void setDisable() {
        getRoot().setDisable(a == null || m == null);
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
        return a;
    }
    public void setTransport(Transport t) {
        a = ((Auto) t);
        setDisable();
        if (a == null)
            return;
        width.setText(String.valueOf(a.getWidth()));
        height.setText(String.valueOf(a.getHeight()));
        depth.setText(String.valueOf(a.getDepth()));
        maxSpeed.setText(String.valueOf(a.getMaxSpeed()));
        teamCount.setText(String.valueOf(a.getTeamCount()));
        passagesCount.setText(String.valueOf(a.getPassagesCount()));
        minWeight.setText(String.valueOf(a.getMinWeight()));
        maxWeight.setText(String.valueOf(a.getMaxWeight()));
        accelerationTimeTo100.setText(String.valueOf(a.getAccelerationTimeTo100()));
        mark.setText(String.valueOf(a.getMark()));
        transmissionType.setText(String.valueOf(a.getTransmissionType()));
    }

    @FXML
    private void initialize() {
        setOnEnterIntSetter(width, width1 -> a.setWidth(width1));
        setOnEnterIntSetter(height, height1 -> a.setHeight(height1));
        setOnEnterIntSetter(depth, depth1 -> a.setDepth(depth1));
        setOnEnterIntSetter(maxSpeed, maxSpeed1 -> a.setMaxSpeed(maxSpeed1));
        setOnEnterIntSetter(teamCount, teamCount1 -> a.setTeamCount(teamCount1));
        setOnEnterIntSetter(passagesCount, passagesCount1 -> a.setPassagesCount(passagesCount1));
        setOnEnterIntSetter(minWeight, minWeight1 -> a.setMinWeight(minWeight1));
        setOnEnterIntSetter(maxWeight, maxWeight1 -> a.setMaxWeight(maxWeight1));
        setOnEnterDoubleSetter(accelerationTimeTo100, accelerationTimeTo1001 -> a.setAccelerationTimeTo100(accelerationTimeTo1001));
        setOnEnterStringSetter(mark, mark1 -> a.setMark(mark1));
        setOnEnterStringSetter(transmissionType, transmissionType1 -> a.setTransmissionType(transmissionType1));
    }
}