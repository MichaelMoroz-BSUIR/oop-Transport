package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import transport.water.Submarine;

public class SubmarineViewModel implements ViewModel<Submarine> {
    @FXML
    private GridPane root;
    @FXML
    private TextField width, height, depth, maxSpeed, teamCount, passagesCount,
            minDisplacement, maxDisplacement, defaultImmersionDepth, maxImmersionDepth, surfaceSpeed;

    public GridPane getRoot() {
        return root;
    }

    public void bind(Submarine s, Main m) {
        if (s == null || m == null)
            return;
        width.setText(String.valueOf(s.getWidth()));
        height.setText(String.valueOf(s.getHeight()));
        depth.setText(String.valueOf(s.getDepth()));
        maxSpeed.setText(String.valueOf(s.getMaxSpeed()));
        teamCount.setText(String.valueOf(s.getTeamCount()));
        passagesCount.setText(String.valueOf(s.getPassagesCount()));
        minDisplacement.setText(String.valueOf(s.getMinDisplacement()));
        maxDisplacement.setText(String.valueOf(s.getMaxDisplacement()));
        defaultImmersionDepth.setText(String.valueOf(s.getDefaultImmersionDepth()));
        maxImmersionDepth.setText(String.valueOf(s.getMaxImmersionDepth()));
        surfaceSpeed.setText(String.valueOf(s.getSurfaceSpeed()));

        ViewModel.setOnEnterIntSetter(width, s::setWidth, m);
        ViewModel.setOnEnterIntSetter(height, s::setHeight, m);
        ViewModel.setOnEnterIntSetter(depth, s::setDepth, m);
        ViewModel.setOnEnterIntSetter(maxSpeed, s::setMaxSpeed, m);
        ViewModel.setOnEnterIntSetter(teamCount, s::setTeamCount, m);
        ViewModel.setOnEnterIntSetter(passagesCount, s::setPassagesCount, m);
        ViewModel.setOnEnterIntSetter(minDisplacement, s::setMinDisplacement, m);
        ViewModel.setOnEnterIntSetter(maxDisplacement, s::setMaxDisplacement, m);
        ViewModel.setOnEnterIntSetter(defaultImmersionDepth, s::setDefaultImmersionDepth, m);
        ViewModel.setOnEnterIntSetter(maxImmersionDepth, s::setMaxImmersionDepth, m);
        ViewModel.setOnEnterIntSetter(surfaceSpeed, s::setSurfaceSpeed, m);
    }

    public static SubmarineViewModel create() {
        return Main.create("submarine.fxml");
    }
}