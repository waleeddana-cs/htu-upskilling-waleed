package jo.edu.htu.currency.convertor;

import java.io.IOException;

public interface GetRateHandler {
    // given: currency from, currency to
    // when: getRate
    // then: Rate

    GetRateResult getRate(GetRateRequest request) throws IOException;
}
