package transport.water;

public class Submarine extends WaterTransport {
    private int defaultImmersionDepth, maxImmersionDepth;
    private int surfaceSpeed;

    public Submarine(int width, int height, int depth,
                     int underwaterSpeed,
                     int teamCount, int passagesCount,
                     int minDisplacement, int maxDisplacement,
                     int defaultImmersionDepth, int maxImmersionDepth,
                     int surfaceSpeed) {
        super(width, height, depth, underwaterSpeed, teamCount, passagesCount, minDisplacement, maxDisplacement);
        setDefaultImmersionDepth(defaultImmersionDepth);
        setMaxImmersionDepth(maxImmersionDepth);
        setSurfaceSpeed(surfaceSpeed);
    }

    public int getDefaultImmersionDepth() {
        return defaultImmersionDepth;
    }
    public void setDefaultImmersionDepth(int defaultImmersionDepth) {
        checkNegative(defaultImmersionDepth);
        this.defaultImmersionDepth = defaultImmersionDepth;
    }

    public int getMaxImmersionDepth() {
        return maxImmersionDepth;
    }
    public void setMaxImmersionDepth(int maxImmersionDepth) {
        checkNegative(maxImmersionDepth);
        this.maxImmersionDepth = maxImmersionDepth;
    }

    public int getSurfaceSpeed() {
        return surfaceSpeed;
    }
    public void setSurfaceSpeed(int surfaceSpeed) {
        this.surfaceSpeed = surfaceSpeed;
    }

    public String toString() {
        return "Submarine{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                ", depth=" + getDepth() +
                ", maxSpeed=" + getMaxSpeed() +
                ", teamCount=" + getTeamCount() +
                ", passagesCount=" + getPassagesCount() +
                ", minDisplacement=" + getMinDisplacement() +
                ", maxDisplacement=" + getMaxDisplacement() +
                ", defaultImmersionDepth=" + getDefaultImmersionDepth() +
                ", maxImmersionDepth=" + getMaxImmersionDepth() +
                ", surfaceSpeed=" + getSurfaceSpeed() +
                '}';
    }
}