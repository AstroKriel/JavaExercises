package patt.ReactorMonitoring;

public class ControlRoom extends RadiationMonitor {
    private double warningThreshold;
    private double observedRadiation;

    /**
     * Constructs a ControlRoom object, which observes reactor radiation readings
     * and prints reports if the radiation exceeds a threshold.
     *
     * @param location         An arbitrary location.
     * @param warningThreshold The radiation threshold for when reports should be printed.
     */
    public ControlRoom(String location, double warningThreshold) {
        super(location);
        this.warningThreshold = warningThreshold;
    }

    /**
     * Updates the monitor with a new observation and prints a report if and only if
     * the observation is equal to or greater than the warning threshold.
     */
    public void update(Subject subject) {
        this.observedRadiation = ((RadiationSensor) subject).getRadiation();
        if (this.warningThreshold <= this.observedRadiation) {
            generateReport();
        }
    }

    /**
     * Generates a report based on the current observation.
     */
    @Override
    public String generateReport() {
        String str = now() + " :: WARNING :: " + String.format("%.4f", this.observedRadiation) + " :: " + getLocation();
        System.out.println(str);
        return str;
    }
}