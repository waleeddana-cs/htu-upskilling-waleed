package jo.edu.htu.statictics;

import java.util.ArrayList;
import java.util.List;

// SOLID
// S: Single Responsibility - done
// O: open for extension closed for modification - done
// L: Liskov principle - done (don't call us, we will call you)
// I: Interface Segregation - 50%
// D: Dependency injection - done
public abstract class Collector<T> implements StatisticsCollector<T> {
    // Template method design pattern
    @Override
    // template (steps to collect statistics from the cases)
    public Iterable<Statistic> collect(Iterable<T> cases) {
        // ask sub-type to give me the names of statistics
        String[] statisticsNames = statisticsNames();
        // as sub-type to give me the count for each one
        int[] valuesOfStatistics = computeStatistics(cases);
        return getStatistics(statisticsNames, valuesOfStatistics);
    }

    private Iterable<Statistic> getStatistics(String[] statisticsNames, int[] valuesOfStatistics) {
        List<Statistic> results = new ArrayList<>();
        for (int i = 0; i < statisticsNames.length; i++) {
            results.add(getStatisticForResult(statisticsNames[i], valuesOfStatistics[i]));
        }
        return results;
    }

    private Statistic getStatisticForResult(String statisticsName, int valuesOfStatistic) {
        return new Statistic() {
            @Override
            public String name() {
                return statisticsName;
            }

            @Override
            public Integer matchedCases() {
                return valuesOfStatistic;
            }

            @Override
            public int compareTo(Statistic statistic) {
                return 0;
            }
        };
    }

    protected abstract String[] statisticsNames();

    protected abstract int[] computeStatistics(Iterable<T> cases);
}
