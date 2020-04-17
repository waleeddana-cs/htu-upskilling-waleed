package jo.edu.htu.currency.convertor;

import java.io.IOException;


public class DefaultConvertAmountHandler implements ConvertAmountHandler {
    @Override
    public ConvertResult convert(ConvertRequest request) throws IOException {
        DefaultGetRateHandler rateHandler = new DefaultGetRateHandler();
        GetRateResult rate = rateHandler.getRate(new GetRateRequest(request.getFrom(), request.getTo()));
        return new ConvertResult(rate.getRate().multiply(request.getAmount()), rate.getRate());
    }
}
