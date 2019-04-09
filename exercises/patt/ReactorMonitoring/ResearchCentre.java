package patt.ReactorMonitoring;


import java.util.ArrayList;
import java.util.List;

public class ResearchCentre extends RadiationMonitor {
    private ArrayList<Double> observations;

    /**
     * Constructs a ResearchCentre object, which observes reactor radiation readings
     * and constantly prints a report with the current moving average of the
     * recorded observations.
     *
     * @param location An arbitrary location.
     */
    public ResearchCentre(String location) {
        super(location);
        this.observations = new ArrayList<>();
    }

    /**
     * Updates the monitor with a new observation and prints a report.
     */
    public void update(Subject subject) {
        this.observations.add(((RadiationSensor) subject).getRadiation());
        generateReport();
    }

    /**
     * Generates a report of the current moving average, updated by a new
     * observation. The moving average is calculated by summing all observations
     * made so far, and dividing by the quantity of observations so far.
     */
    public String generateReport() {
        double averageObservation = 0;

        if (!observations.isEmpty()) {
            for (double observation : observations) {
                averageObservation += observation;
            }
            averageObservation /= ((double) observations.size());
        }

        String str = now() + " :: moving average :: " + String.format("%.4f", averageObservation)
                + " :: " + getLocation();
        System.out.println(str);
        return str;
    }
}