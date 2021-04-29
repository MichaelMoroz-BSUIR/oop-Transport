package transport.air;

public class Helicopter extends AirTransport {
    private int rotorDiameter;

    public Helicopter(int width, int height, int depth,
                      int minWeight, int maxWeight,
                      int maxSpeed,
                      int teamCount, int passagesCount,
                      int maximumFlightAltitude, int rotorDiameter) {
        super(width, height, depth, minWeight, maxWeight, maxSpeed, teamCount, passagesCount, maximumFlightAltitude);
        setRotorDiameter(rotorDiameter);
    }

    public int getRotorDiameter() {
        return rotorDiameter;
    }
    public void setRotorDiameter(int rotorDiameter) {
        checkNegative(rotorDiameter);
        this.rotorDiameter = rotorDiameter;
    }

    public String toString() {
        return "Helicopter{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                ", depth=" + getDepth() +
                ", maxSpeed=" + getMaxSpeed() +
                ", teamCount=" + getTeamCount() +
                ", passagesCount=" + getPassagesCount() +
                ", minWeight=" + getMinWeight() +
                ", maxWeight=" + getMaxWeight() +
                ", maximumFlightAltitude=" + getMaxFlightAltitude() +
                ", rotorDiameter=" + getRotorDiameter() +
                '}';
    }
}
