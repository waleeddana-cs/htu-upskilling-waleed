package jo.edu.htu.statictics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntCollectorTest {

    @Test
    public void givenCollector_whenCollect_thenDataStatisticsReturnedAsExpected() {
        StatisticsCollector<Integer> collector = new IntCollector();

        Iterable<Integer> cases = Arrays.asList(3, -1, 10, 15, 16, -100, 24);
        Iterable<Statistic> statistics = collector.collect(cases);
        Assertions.assertNotNull(statistics, "returned statistics is null");
        Map<String, Integer> asMap = new HashMap<>();
        for (Statistic statistic : statistics) {
            Assertions.assertNotNull(statistic, "one of returned statistics is null");
            String name = statistic.name();
            Integer value = statistic.matchedCases();
            Assertions.assertNotNull(name, "statistic name is null");
            Assertions.assertNotNull(value, "statistic with name " + name + " has null value");
            Assertions.assertNull(asMap.put(name, value), "it seems there is duplicate keys in the result: " + name);
        }

        Map<String, Integer> expectedCases = new HashMap<>();
        expectedCases.put("Odd", 3);
        expectedCases.put("Even", 4);

        Assertions.assertEquals(expectedCases, asMap, "the returned statistics are not as expected");
    }
}
