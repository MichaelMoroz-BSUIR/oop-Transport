package transport.land;

import transport.Transport;

public class Train extends Transport {
    private int wagonsCount;

    public Train(int width, int height, int depth,
                 int maxSpeed,
                 int teamCount, int passagesCount,
                 int wagonsCount) {
        super(width, height, depth, maxSpeed, teamCount, passagesCount);
        setWagonsCount(wagonsCount);
    }

    public int getWagonsCount() {
        return wagonsCount;
    }
    public void setWagonsCount(int wagonsCount) {
        checkNegative(wagonsCount);
        this.wagonsCount = wagonsCount;
    }

    public String toString() {
        return "Train{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                ", depth=" + getDepth() +
                ", maxSpeed=" + getMaxSpeed() +
                ", teamCount=" + getTeamCount() +
                ", passagesCount=" + getPassagesCount() +
                ", wagonsCount=" + getWagonsCount() +
                '}';
    }
}