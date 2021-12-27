package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.Currency;
import model.CurrencySet;

public class MockCurrencySetLoader implements CurrencySetLoader {

    private static MockCurrencySetLoader instance;

    private MockCurrencySetLoader() {
    }

    public static MockCurrencySetLoader getInstance() {
        if (instance == null)
            instance = new MockCurrencySetLoader();
        return instance;
    }

    @Override
    public void load() {
        CurrencySet set = CurrencySet.getInstance();
        try {
            FileReader fr = new FileReader("currencies");
            BufferedReader br = new BufferedReader(fr);

            String text = "";

            while ((text = br.readLine()) != null) {
                String[] split = text.split(",");

                set.add(new Currency(split[1], split[0],split[2]));
            }
        } catch (IOException e) {}
    }
}       