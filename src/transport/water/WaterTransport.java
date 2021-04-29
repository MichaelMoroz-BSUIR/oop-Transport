package transport.water;

import transport.Transport;

public class WaterTransport extends Transport {
    private int minDisplacement, maxDisplacement;

    public WaterTransport(int width, int height, int depth,
                          int maxSpeed,
                          int teamCount, int passagesCount,
                          int minDisplacement, int maxDisplacement) {
        super(width, height, depth, maxSpeed, teamCount, passagesCount);
        setMinDisplacement(minDisplacement);
        setMaxDisplacement(maxDisplacement);
    }

    public int getMinDisplacement() {
        return minDisplacement;
    }
    public void setMinDisplacement(int minDisplacement) {
        checkNegative(minDisplacement);
        this.minDisplacement = minDisplacement;
    }

    public int getMaxDisplacement() {
        return maxDisplacement;
    }
    public void setMaxDisplacement(int maxDisplacement) {
        checkNegative(maxDisplacement);
        this.maxDisplacement = maxDisplacement;
    }
}
