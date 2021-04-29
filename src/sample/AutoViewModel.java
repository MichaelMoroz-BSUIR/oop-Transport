package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import transport.land.Auto;

public class AutoViewModel implements ViewModel<Auto> {
    @FXML
    private GridPane root;
    @FXML
    private TextField width, height, depth, maxSpeed, teamCount, passagesCount,
            minWeight, maxWeight, accelerationTimeTo100, mark, transmissionType;

    public GridPane getRoot() {
        return root;
    }

    public void bind(Auto a, Main m) {
        if (a == null || m == null)
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

        ViewModel.setOnEnterIntSetter(width, a::setWidth, m);
        ViewModel.setOnEnterIntSetter(height, a::setHeight, m);
        ViewModel.setOnEnterIntSetter(depth, a::setDepth, m);
        ViewModel.setOnEnterIntSetter(maxSpeed, a::setMaxSpeed, m);
        ViewModel.setOnEnterIntSetter(teamCount, a::setTeamCount, m);
        ViewModel.setOnEnterIntSetter(passagesCount, a::setPassagesCount, m);
        ViewModel.setOnEnterIntSetter(minWeight, a::setMinWeight, m);
        ViewModel.setOnEnterIntSetter(maxWeight, a::setMaxWeight, m);
        ViewModel.setOnEnterDoubleSetter(accelerationTimeTo100, a::setAccelerationTimeTo100, m);
        ViewModel.setOnEnterStringSetter(mark, a::setMark, m);
        ViewModel.setOnEnterStringSetter(transmissionType, a::setTransmissionType, m);
    }

    public static AutoViewModel create() {
        return Main.create("auto.fxml");
    }
}