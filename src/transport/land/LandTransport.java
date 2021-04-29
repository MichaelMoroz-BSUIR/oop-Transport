package transport.land;

import transport.Transport;

public class LandTransport extends Transport {
    private int minWeight, maxWeight;

    public LandTransport(int width, int height, int depth,
                         int maxSpeed,
                         int teamCount, int passagesCount,
                         int minWeight, int maxWeight) {
        super(width, height, depth, maxSpeed, teamCount, passagesCount);
        setMinWeight(minWeight);
        setMaxWeight(maxWeight);
    }

    public int getMinWeight() {
        return minWeight;
    }
    public void setMinWeight(int minWeight) {
        checkNegative(minWeight);
        this.minWeight = minWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
    public void setMaxWeight(int maxWeight) {
        checkNegative(maxWeight);
        this.maxWeight = maxWeight;
    }
}
