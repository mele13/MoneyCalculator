package persistence;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Currency;
import model.CurrencySet;
import model.ExchangeRate;
import model.Number;

public class MockExchangeRateLoader implements ExchangeRateLoader {

    private final List<ExchangeRate> exchangeRateList;

    public MockExchangeRateLoader() {
        exchangeRateList = new ArrayList<>();
        exchangeRateList.add(
                new ExchangeRate(
                        CurrencySet.getInstance().search("EUR")[0],
                        CurrencySet.getInstance().search("EUR")[0],
                        new Number(1)));
        exchangeRateList.add(
                new ExchangeRate(
                        CurrencySet.getInstance().search("EUR")[0],
                        CurrencySet.getInstance().search("GBP")[0],
                        new Number(0.82)));
        exchangeRateList.add(
                new ExchangeRate(
                        CurrencySet.getInstance().search("EUR")[0],
                        CurrencySet.getInstance().search("USD")[0],
                        new Number(1.36)));
        exchangeRateList.add(
                new ExchangeRate(
                        CurrencySet.getInstance().search("EUR")[0],
                        CurrencySet.getInstance().search("CNY")[0],
                        new Number(8.2)));
        exchangeRateList.add(
                new ExchangeRate(
                        CurrencySet.getInstance().search("EUR")[0],
                        CurrencySet.getInstance().search("AUD")[0],
                        new Number(1.53)));
    }

    @Override
    public ExchangeRate load(Date date, Currency to, Currency from) {
        return new ExchangeRate(date, from, to, getRate(from, to));
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return new ExchangeRate(from, to, getRate(from, to));
    }
   

    private String read(URL url) throws IOException{
        InputStream is = url.openStream();
        byte[] buffer = new byte[1024];
        int length = is.read(buffer);
        return new String(buffer,0,length);
    }

    private Number getRate(Currency from, Currency to) {
        Currency euro = CurrencySet.getInstance().search("EUR")[0];
        Number toEuro = null;

        for (ExchangeRate rate : exchangeRateList)
            if (rate.getFrom() == euro && rate.getTo() == from) {
                toEuro = rate.getRate();
                break;
            }

        if (toEuro != null)
            for (ExchangeRate rate : exchangeRateList)
                if (rate.getTo() == to && rate.getFrom() == euro)
                    return rate.getRate().divide(toEuro);

        return new Number(1);
    }
}