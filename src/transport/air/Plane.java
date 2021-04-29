package transport.air;

public class Plane extends AirTransport {
    private int wingArea;

    public Plane(int width, int height, int depth,
                 int minWeight, int maxWeight,
                 int maxSpeed,
                 int teamCount, int passagesCount,
                 int maximumFlightAltitude, int wingArea) {
        super(width, height, depth, maxSpeed, teamCount, passagesCount, minWeight, maxWeight, maximumFlightAltitude);
        setWingArea(wingArea);
    }

    public int getWingArea() {
        return wingArea;
    }
    public void setWingArea(int wingArea) {
        checkNegative(wingArea);
        this.wingArea = wingArea;
    }

    public String toString() {
        return "Plane{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                ", depth=" + getDepth() +
                ", maxSpeed=" + getMaxSpeed() +
                ", teamCount=" + getTeamCount() +
                ", passagesCount=" + getPassagesCount() +
                ", minWeight=" + getMinWeight() +
                ", maxWeight=" + getMaxWeight() +
                ", maximumFlightAltitude=" + getMaxFlightAltitude() +
                ", wingArea=" + getWingArea() +
                '}';
    }
}