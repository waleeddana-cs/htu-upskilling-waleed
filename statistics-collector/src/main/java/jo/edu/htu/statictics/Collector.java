package jo.edu.htu.statictics;

import java.util.List;

public abstract class Collector<T> implements StatisticsCollector<T> {
    List<Statistic> results;
    String[] statistics;
    int[] valuesOfStatistics;

    @Override
    public Iterable<Statistic> collect(Iterable<T> cases) {
        computeStatistics(cases);
        for (int i = 0; i < statistics.length; i++) {
            int currentIndex = i;
            results.add(new Statistic() {
                @Override
                public String name() {
                    return statistics[currentIndex];
                }

                @Override
                public Integer matchedCases() {
                    return valuesOfStatistics[currentIndex];
                }

                @Override
                public int compareTo(Statistic statistic) {
                    return 0;
                }
            });

        }
        return results;
    }

    abstract void computeStatistics(Iterable<T> cases);
}
