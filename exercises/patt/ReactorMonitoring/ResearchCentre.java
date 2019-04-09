package patt.ReactorMonitoring;


public class ResearchCentre extends RadiationMonitor {
    private double sum_observations;
    private double numObservations;

    /**
     * Constructs a ResearchCentre object, which observes reactor radiation readings
     * and constantly prints a report with the current moving average of the
     * recorded observations.
     *
     * @param location An arbitrary location.
     */
    public ResearchCentre(String location) {
        super(location);
        this.sum_observations = 0;
    }

    /**
     * Updates the monitor with a new observation and prints a report.
     */
    public void update(Subject subject) {
        this.sum_observations += ((RadiationSensor) subject).getRadiation();
        this.numObservations++;
        generateReport();
    }

    /**
     * Generates a report of the current moving average, updated by a new
     * observation. The moving average is calculated by summing all observations
     * made so far, and dividing by the quantity of observations so far.
     */
    public String generateReport() {
        double averageObservation = this.sum_observations/this.numObservations;
        String str = now() + " :: moving average :: " + String.format("%.4f", averageObservation)
                + " :: " + getLocation();
        System.out.println(str);
        return str;
    }
}