package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import transport.land.Train;

public class TrainViewModel implements ViewModel<Train> {
    @FXML
    private GridPane root;
    @FXML
    private TextField width, height, depth, maxSpeed, teamCount, passagesCount, wagonsCount;

    public GridPane getRoot() {
        return root;
    }

    public void bind(Train t, Main m) {
        if (t == null || m == null)
            return;
        width.setText(String.valueOf(t.getWidth()));
        height.setText(String.valueOf(t.getHeight()));
        depth.setText(String.valueOf(t.getDepth()));
        maxSpeed.setText(String.valueOf(t.getMaxSpeed()));
        teamCount.setText(String.valueOf(t.getTeamCount()));
        passagesCount.setText(String.valueOf(t.getPassagesCount()));
        wagonsCount.setText(String.valueOf(t.getWagonsCount()));

        ViewModel.setOnEnterIntSetter(width, t::setWidth, m);
        ViewModel.setOnEnterIntSetter(height, t::setHeight, m);
        ViewModel.setOnEnterIntSetter(depth, t::setDepth, m);
        ViewModel.setOnEnterIntSetter(maxSpeed, t::setMaxSpeed, m);
        ViewModel.setOnEnterIntSetter(teamCount, t::setTeamCount, m);
        ViewModel.setOnEnterIntSetter(passagesCount, t::setPassagesCount, m);
        ViewModel.setOnEnterIntSetter(wagonsCount, t::setWagonsCount, m);
    }

    public static TrainViewModel create() {
        return Main.create("train.fxml");
    }
}