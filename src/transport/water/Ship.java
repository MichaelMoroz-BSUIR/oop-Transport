package transport.water;

public class Ship extends WaterTransport {
    private int sailingRange;

    public Ship(int width, int height, int depth,
                int maxSpeed,
                int teamCount, int passagesCount,
                int minDisplacement, int maxDisplacement,
                int sailingRange) {
        super(width, height, depth, maxSpeed, teamCount, passagesCount, minDisplacement, maxDisplacement);
        setSailingRange(sailingRange);
    }

    public int getSailingRange() {
        return sailingRange;
    }
    public void setSailingRange(int sailingRange) {
        checkNegative(sailingRange);
        this.sailingRange = sailingRange;
    }

    public String toString() {
        return "Ship{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                ", depth=" + getDepth() +
                ", maxSpeed=" + getMaxSpeed() +
                ", teamCount=" + getTeamCount() +
                ", passagesCount=" + getPassagesCount() +
                ", minDisplacement=" + getMinDisplacement() +
                ", maxDisplacement=" + getMaxDisplacement() +
                "sailingRange=" + getSailingRange() +
                '}';
    }
}