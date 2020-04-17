package jo.edu.htu.currency.convertor;

import java.math.BigDecimal;
import java.util.Objects;

public class Currency {
    String name;
    BigDecimal price;

    public Currency(String name, BigDecimal price) {
        this.name = name;
        this.price = BigDecimal.valueOf(price.doubleValue());
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Currency currency = (Currency) o;
        return Objects.equals(getName(), currency.getName()) &&
                Objects.equals(getPrice(), currency.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }

    public BigDecimal getPrice() {
        return price;
    }
}
