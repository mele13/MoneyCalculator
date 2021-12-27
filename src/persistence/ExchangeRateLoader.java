package persistence;

import java.util.Date;
import model.Currency;
import model.ExchangeRate;

public interface ExchangeRateLoader {
    public ExchangeRate load(Date date, Currency to, Currency from);
    public ExchangeRate load(Currency to, Currency from);
}
