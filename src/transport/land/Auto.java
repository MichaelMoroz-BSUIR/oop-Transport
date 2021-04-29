package transport.land;

public class Auto extends LandTransport {
    private float accelerationTimeTo100;
    private String mark, transmissionType;

    public Auto(int width, int height, int depth,
                int maxSpeed,
                int teamCount, int passagesCount,
                int minWeight, int maxWeight,
                double accelerationTimeTo100, String mark, String transmissionType) {
        super(width, height, depth, maxSpeed, teamCount, passagesCount, minWeight, maxWeight);
        setAccelerationTimeTo100(accelerationTimeTo100);
        setMark(mark);
        setTransmissionType(transmissionType);
    }

    public double getAccelerationTimeTo100() {
        return accelerationTimeTo100;
    }
    public void setAccelerationTimeTo100(double accelerationTimeTo100) {
        if (accelerationTimeTo100 < 0.0)
            throw new IllegalArgumentException("Negative value");
        this.accelerationTimeTo100 = (float) accelerationTimeTo100;
    }

    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        if (mark == null)
            throw new NullPointerException();
        this.mark = mark;
    }

    public String getTransmissionType() {
        return transmissionType;
    }
    public void setTransmissionType(String transmissionType) {
        if (transmissionType == null)
            throw new NullPointerException();
        this.transmissionType = transmissionType;
    }

    public String toString() {
        return "Auto{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                ", depth=" + getDepth() +
                ", maxSpeed=" + getMaxSpeed() +
                ", teamCount=" + getTeamCount() +
                ", passagesCount=" + getPassagesCount() +
                ", minWeight=" + getMinWeight() +
                ", maxWeight=" + getMaxWeight() +
                ", accelerationTimeTo100=" + getAccelerationTimeTo100() +
                ", mark='" + getMark() + '\'' +
                ", transmissionType='" + getTransmissionType() + '\'' +
                '}';
    }
}