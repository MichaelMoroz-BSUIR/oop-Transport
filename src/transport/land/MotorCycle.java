package transport.land;

public class MotorCycle extends LandTransport {
    private float accelerationTimeTo100;
    private String mark;

    public MotorCycle(int width, int height, int depth,
                      int maxSpeed,
                      int teamCount, int passagesCount,
                      int minWeight, int maxWeight,
                      double accelerationTimeTo100, String mark) {
        super(width, height, depth, maxSpeed, teamCount, passagesCount, minWeight, maxWeight);
        setAccelerationTimeTo100(accelerationTimeTo100);
        setMark(mark);
    }

    public double getAccelerationTimeTo100() {
        return accelerationTimeTo100;
    }
    public void setAccelerationTimeTo100(double accelerationTimeTo100) {
        checkNegative(accelerationTimeTo100);
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

    public String toString() {
        return "MotorCycle{" +
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
                '}';
    }
}