package transport.air;

import transport.Transport;

public class AirTransport extends Transport {
    private int minWeight, maxWeight;
    private int maxFlightAltitude;

    public AirTransport(int width, int height, int depth,
                        int maxSpeed,
                        int teamCount, int passagesCount,
                        int minWeight, int maxWeight,
                        int maxFlightAltitude) {
        super(width, height, depth, maxSpeed, teamCount, passagesCount);
        setMinWeight(minWeight);
        setMaxWeight(maxWeight);
        setMaxFlightAltitude(maxFlightAltitude);
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

    public int getMaxFlightAltitude() {
        return maxFlightAltitude;
    }
    public void setMaxFlightAltitude(int maxFlightAltitude) {
        checkNegative(maxFlightAltitude);
        this.maxFlightAltitude = maxFlightAltitude;
    }


}