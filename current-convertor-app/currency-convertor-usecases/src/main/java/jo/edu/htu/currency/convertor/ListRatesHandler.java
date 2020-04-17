package jo.edu.htu.currency.convertor;

import java.io.IOException;

public interface ListRatesHandler {
    // given: currency from, to +1
    //        USD -> JOD, JPY, CAD, SYL
    // when: getRates
    // then: rates for each to (JOD: 1.14, JPY: 2000, )

    ListRatesResult getRates(ListRatesRequest request) throws IOException;
}
