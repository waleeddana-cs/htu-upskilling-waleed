package jo.edu.htu.currency.convertor;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DefaultListRatesHandler implements ListRatesHandler {

    @Override
    public ListRatesResult getRates(ListRatesRequest request) throws IOException {
        Map<String, BigDecimal> result = new HashMap<>();
        DefaultGetRateHandler rateHandler = new DefaultGetRateHandler();
        for (String toCode : request.getToCodes()) {
            result.put(toCode, rateHandler.getRate(new GetRateRequest(request.getFrom(), toCode)).getRate());
        }
        return new ListRatesResult(result);
    }
}
