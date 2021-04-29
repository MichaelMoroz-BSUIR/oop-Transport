package transport;

public class Transport {
    private int width, height, depth;
    private int maxSpeed;
    private int teamCount, passagesCount;

    public Transport(int width, int height, int depth,
                     int maxSpeed,
                     int teamCount, int passagesCount) {
        setWidth(width);
        setHeight(height);
        setDepth(depth);
        setMaxSpeed(maxSpeed);
        setTeamCount(teamCount);
        setPassagesCount(passagesCount);
    }

    protected static void checkNegative(int value) {
        if (value < 0)
            throw new IllegalArgumentException("Negative value");
    }
    protected static void checkNegative(double value) {
        if (value < 0.0)
            throw new IllegalArgumentException("Negative value");
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        checkNegative(width);
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        checkNegative(height);
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }
    public void setDepth(int depth) {
        checkNegative(depth);
        this.depth = depth;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
        checkNegative(maxSpeed);
        this.maxSpeed = maxSpeed;
    }

    public int getTeamCount() {
        return teamCount;
    }
    public void setTeamCount(int teamCount) {
        checkNegative(teamCount);
        this.teamCount = teamCount;
    }

    public int getPassagesCount() {
        return passagesCount;
    }
    public void setPassagesCount(int passagesCount) {
        checkNegative(passagesCount);
        this.passagesCount = passagesCount;
    }
}