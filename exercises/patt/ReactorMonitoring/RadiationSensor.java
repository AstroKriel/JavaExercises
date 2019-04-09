package patt.ReactorMonitoring;

import java.util.Random;

public class RadiationSensor extends Subject {
    Random rand;
    private String location;
    private double radiation;

    /**
     * Constructs a RadiationSensor object
     *
     * @param location An arbitrary location.
     * @param seed     A seed for the random number generator used to simulate radiation readings.
     */
    public RadiationSensor(String location, int seed) {
        this.rand = new Random(seed);
        this.location = location;
    }

    /**
     * Gets the location
     *
     * @return location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the radiation.
     *
     * @return radiation
     */
    public double getRadiation() {
        return radiation;
    }

    /**
     * Updates radiation and notifies all observers of the change.
     */
    public void readRadiation() {
        this.radiation = this.rand.nextDouble()*10;
        notifyObservers();
    }
}