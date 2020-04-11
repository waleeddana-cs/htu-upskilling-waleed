package jo.edu.htu.statictics;

public class StringsCollector extends Collector<String> {

    @Override
    protected String[] statisticsNames() {
        return  new String[]{"upper case letters", "lower case letters", "spaces count", "non-word characters"};
    }

    protected int[] computeStatistics(Iterable<String> cases) {
        int[] valuesOfStatistics = new int[4];

        for (String aCase : cases) {
            for (int i = 0; i < aCase.length(); i++) {
                if (Character.isUpperCase(aCase.charAt(i)))
                    valuesOfStatistics[0]++;
                else if (Character.isLowerCase(aCase.charAt(i)))
                    valuesOfStatistics[1]++;
                else if (aCase.charAt(i) == ' ')
                    valuesOfStatistics[2]++;
                else if (!Character.isDigit(aCase.charAt(i)))
                    valuesOfStatistics[3]++;
            }
        }
        return valuesOfStatistics;
    }
}