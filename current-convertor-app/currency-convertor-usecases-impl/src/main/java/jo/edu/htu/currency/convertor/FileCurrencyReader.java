package jo.edu.htu.currency.convertor;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class FileCurrencyReader {
    Path path;
    Set<Currency> currencies;

    public FileCurrencyReader(Path path) throws IOException {
        this.path = path;
        currencies = new HashSet<>();
        readFile();
    }

    private void readFile() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                if (counter == 0 || counter == 193 || counter == 386) {
                    counter++;
                    continue;
                }
                fetchCurrency(line);
                counter++;
            }
        }
    }

    private void fetchCurrency(String line) {
        String[] currencyTemp = line.split(",");
        String name = (currencyTemp[2].split(":"))[0].toUpperCase();
        BigDecimal price;
        int count = 1;
        while (true) {
            String lastPrice = currencyTemp[currencyTemp.length - count];
            if (!lastPrice.equals("") || Double.parseDouble(lastPrice) > 0) {
                price = BigDecimal.valueOf(Double.parseDouble(lastPrice));
                break;
            }
            count++;
        }
        Currency currency = new Currency(name.substring(1), price);
        currencies.add(currency);
    }

    public Path getPath() {
        return path;
    }

    public BigDecimal getCurrency(String name) {
        for (Currency currency : currencies) {
            if (name.equals(currency.getName()))
                return currency.price;
        }
        return null;
    }
}
