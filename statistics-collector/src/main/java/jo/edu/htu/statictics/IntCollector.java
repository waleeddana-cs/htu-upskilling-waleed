package jo.edu.htu.statictics;

public class IntCollector extends Collector<Integer> {

    @Override
    protected String[] statisticsNames() {
        return new String[]{"Even", "Odd"};
    }

    @Override
    protected int[] computeStatistics(Iterable<Integer> cases) {
        int[] counts = new int[2];
        for (Integer aCase : cases) {
            counts[Math.abs(aCase % 2)]++;
        }
        return counts;
    }
}
