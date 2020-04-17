package jo.edu.htu.currency.convertor;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DefaultGetRateHandler implements GetRateHandler {
    private final FileCurrencyReader reader;

    public DefaultGetRateHandler() throws IOException {
        Path data = Paths.get(".", "table-i3-e.csv");
        this.reader = new FileCurrencyReader(data);
    }

    @Override
    public GetRateResult getRate(GetRateRequest request) {
        if (request.getFrom().equals("USD")) {
            return shortGetRate(request);
        }
        if (request.getTo().equals("USD")) {
            return reverseGetRate(request);
        }
        if (request.getFrom().equals(request.getTo())) {
            return new GetRateResult(BigDecimal.valueOf(1));
        }

        return longGetRate(request);
    }

    private GetRateResult longGetRate(GetRateRequest request) {
        BigDecimal leftToUsd = reverseGetRate(new GetRateRequest(request.getFrom(), "USD")).getRate();
        BigDecimal usdToRight = shortGetRate(new GetRateRequest("USD", request.getTo())).getRate();
        return new GetRateResult(leftToUsd.multiply(usdToRight));
    }

    private GetRateResult reverseGetRate(GetRateRequest request) {
        BigDecimal one = BigDecimal.valueOf(1.0);
        BigDecimal currency = reader.getCurrency(request.getFrom());
        BigDecimal rate = one.divide(currency, 3, RoundingMode.HALF_UP);
        return new GetRateResult(rate);
    }

    private GetRateResult shortGetRate(GetRateRequest request) {
        BigDecimal currencyPrice = reader.getCurrency(request.getTo());
        return new GetRateResult(currencyPrice);
    }
}
