package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CurrencySet extends HashSet<Currency> {

    private static CurrencySet instance;

    private CurrencySet() {
        super();
    }

    public static CurrencySet getInstance() {
        if (instance == null)
            instance = new CurrencySet();
        return instance;
    }

    public String[] getArray() {
        CurrencySet currencySet = CurrencySet.getInstance();
        String[] currencies = new String[currencySet.size()];
        int i = 0;
        
        for (Currency currency : currencySet)
            currencies[i++] = currency.getCode();
        
        Arrays.sort(currencies);
        return currencies;
    }

    public Currency getFromCode(String code) {
        for (Currency currency : this)
            if (code.equals(currency.getCode()))
                return currency;
        return null;
    }

    public Currency[] search(String token) {
        ArrayList<Currency> list = new ArrayList<>();
        for (Currency currency : this)
            if (currency.getCode().equalsIgnoreCase(token))
                list.add(currency);
            else if (currency.getSymbol().equalsIgnoreCase(token))
                list.add(currency);
            else if (currency.getName().toLowerCase().contains(token.toLowerCase()))
                list.add(currency);

        return list.toArray(new Currency[0]);
    }

}
