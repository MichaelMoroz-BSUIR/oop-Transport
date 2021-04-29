package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import transport.land.MotorCycle;

public class MotorCycleViewModel implements ViewModel<MotorCycle> {
    @FXML
    private GridPane root;
    @FXML
    private TextField width, height, depth, maxSpeed, teamCount, passagesCount,
            minWeight, maxWeight, accelerationTimeTo100, mark;

    public GridPane getRoot() {
        return root;
    }

    public void bind(MotorCycle c, Main m) {
        if (c == null || m == null)
            return;
        width.setText(String.valueOf(c.getWidth()));
        height.setText(String.valueOf(c.getHeight()));
        depth.setText(String.valueOf(c.getDepth()));
        maxSpeed.setText(String.valueOf(c.getMaxSpeed()));
        teamCount.setText(String.valueOf(c.getTeamCount()));
        passagesCount.setText(String.valueOf(c.getPassagesCount()));
        minWeight.setText(String.valueOf(c.getMinWeight()));
        maxWeight.setText(String.valueOf(c.getMaxWeight()));
        accelerationTimeTo100.setText(String.valueOf(c.getAccelerationTimeTo100()));
        mark.setText(String.valueOf(c.getMark()));

        ViewModel.setOnEnterIntSetter(width, c::setWidth, m);
        ViewModel.setOnEnterIntSetter(height, c::setHeight, m);
        ViewModel.setOnEnterIntSetter(depth, c::setDepth, m);
        ViewModel.setOnEnterIntSetter(maxSpeed, c::setMaxSpeed, m);
        ViewModel.setOnEnterIntSetter(teamCount, c::setTeamCount, m);
        ViewModel.setOnEnterIntSetter(passagesCount, c::setPassagesCount, m);
        ViewModel.setOnEnterIntSetter(minWeight, c::setMinWeight, m);
        ViewModel.setOnEnterIntSetter(maxWeight, c::setMaxWeight, m);
        ViewModel.setOnEnterDoubleSetter(accelerationTimeTo100, c::setAccelerationTimeTo100, m);
        ViewModel.setOnEnterStringSetter(mark, c::setMark, m);
    }

    public static MotorCycleViewModel create() {
        return Main.create("motorCycle.fxml");
    }
}