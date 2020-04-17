package jo.edu.htu.currency.convertor;

import java.io.IOException;

// represent the case for "convert amount"
public interface ConvertAmountHandler {
    // given: currency from, currency to, amount
    // when: convert
    // then: converted amount, rate
    ConvertResult convert(ConvertRequest request) throws IOException;
}
