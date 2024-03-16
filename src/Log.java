public class Log {

    private final boolean isSorted;
    private final int arraySize;
    private final long sortDurationMillis;
    private final long loopDurationMillis;
    private final long totalDurationMillis;


    public Log(boolean isSorted, int arraySize, long sortDurationMillis, long loopDurationMillis, long totalDurationMillis) {
        this.isSorted = isSorted;
        this.arraySize = arraySize;
        this.sortDurationMillis = sortDurationMillis;
        this.loopDurationMillis = loopDurationMillis;
        this.totalDurationMillis = totalDurationMillis;
    }

    @Override
    public String toString() {
        return "Log{" +
                "isSorted=" + isSorted +
                ", arraySize=" + arraySize +
                ", sortDurationMillis=" + sortDurationMillis +
                ", loopDurationMillis=" + loopDurationMillis +
                ", totalDurationMillis=" + totalDurationMillis +
                '}';
    }
}
