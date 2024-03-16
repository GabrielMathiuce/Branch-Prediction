public class Metric {

    private final double averageDuration;
    private final long fastestRun;
    private final long slowestRun;

    public Metric(double averageDuration, long fastestRun, long slowestRun) {
        this.averageDuration = averageDuration;
        this.fastestRun = fastestRun;
        this.slowestRun = slowestRun;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "averageDuration=" + averageDuration +
                ", fastestRun=" + fastestRun +
                ", slowestRun=" + slowestRun +
                '}';
    }
}
