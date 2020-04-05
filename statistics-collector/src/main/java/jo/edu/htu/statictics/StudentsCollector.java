package jo.edu.htu.statictics;

import java.util.ArrayList;

public class StudentsCollector extends Collector<Student> {

    void computeStatistics(Iterable<Student> cases) {
        results = new ArrayList<>(6);
        statistics = new String[]{"CIS major", "Computer Science major", "graduation year <= 2016", "graduation year > 2016", "Males", "Females"};
        valuesOfStatistics = new int[6];

        for (Student aCase : cases) {
            if (aCase.getMajor().equals("CIS"))
                valuesOfStatistics[0]++;
            else
                valuesOfStatistics[1]++;
            if (aCase.getGraduationYear().getValue() <= 2016)
                valuesOfStatistics[2]++;
            else
                valuesOfStatistics[3]++;
            if (aCase.getGender().equals(Gender.MALE))
                valuesOfStatistics[4]++;
            else
                valuesOfStatistics[5]++;
        }
    }
}