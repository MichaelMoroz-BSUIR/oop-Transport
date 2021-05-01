package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import transport.Transport;
import transport.water.Submarine;

public class SubmarineViewModel implements ViewModel {
    public static SubmarineViewModel create() {
        return Main.create("submarine.fxml");
    }

    @FXML
    private GridPane root;
    @FXML
    private TextField width, height, depth, maxSpeed, teamCount, passagesCount,
            minDisplacement, maxDisplacement, defaultImmersionDepth, maxImmersionDepth, surfaceSpeed;

    private Main m;
    private Submarine v;

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
        v = ((Submarine) t);
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
        defaultImmersionDepth.setText(String.valueOf(v.getDefaultImmersionDepth()));
        maxImmersionDepth.setText(String.valueOf(v.getMaxImmersionDepth()));
        surfaceSpeed.setText(String.valueOf(v.getSurfaceSpeed()));
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
        setOnEnterIntSetter(defaultImmersionDepth, defaultImmersionDepth1 -> v.setDefaultImmersionDepth(defaultImmersionDepth1));
        setOnEnterIntSetter(maxImmersionDepth, maxImmersionDepth1 -> v.setMaxImmersionDepth(maxImmersionDepth1));
        setOnEnterIntSetter(surfaceSpeed, surfaceSpeed1 -> v.setSurfaceSpeed(surfaceSpeed1));
    }
}