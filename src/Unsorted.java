import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Unsorted {
    public static void main(String[] args) throws IOException {

        int[] arraySizes = new int[]{1000, 10000, 100000, 1000000};
        int runs = 11;
        List<String> logs = new ArrayList<>();
        Path file = Paths.get("Your/Path/Here");

        for (int arraySize : arraySizes) {

            long fastestRun = Long.MAX_VALUE;
            long slowestRun = Long.MIN_VALUE;
            double averageRun = 0;

            for (int i = 1; i < runs; i++) {

                int[] data = new int[arraySize];

                Random rnd = new Random(0);
                for (int j = 0; j < arraySize; j++)
                    data[j] = rnd.nextInt() % 256;

                long loopIterationStartMillis = System.currentTimeMillis();
                long sum = 0;

                for (int k = 0; k < 100000; k++) {
                    for (int l = 0; l < arraySize; l++) {
                        if (data[l] >= 128)
                            sum += data[l];
                    }
                }

                long loopIterationEndMillis = System.currentTimeMillis();
                long totalDurationMillis = loopIterationEndMillis - loopIterationStartMillis;

                if(totalDurationMillis < fastestRun)
                    fastestRun = totalDurationMillis;
                if(totalDurationMillis > slowestRun)
                    slowestRun = totalDurationMillis;

                averageRun += totalDurationMillis;
                logs.add(new Log(false, arraySize, 0, totalDurationMillis, totalDurationMillis).toString());
            }
            logs.add(new Metric((averageRun * 0.10), fastestRun, slowestRun).toString());
        }
        Files.write(file, logs, StandardCharsets.UTF_8);
    }
}
