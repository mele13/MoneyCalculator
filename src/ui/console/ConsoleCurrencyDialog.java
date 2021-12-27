package ui.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Currency;
import model.CurrencySet;
import ui.CurrencyDialog;

public class ConsoleCurrencyDialog implements CurrencyDialog {

    private Currency currency;

    @Override
    public Currency getCurrency() {
        return currency;
    }

    public void execute() {
        String line = null;
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduce una divisa:");
            try {
                line = readCurrency(reader);
            } catch (IOException ex) {
            }
            Currency[] currencies = CurrencySet.getInstance().search(line);
            if (check(currencies))
                break;
        }
    }

    private String readCurrency(BufferedReader reader) throws IOException {
        return reader.readLine();
    }

    private boolean check(Currency[] currencies) {
        if (currencies.length == 0) {
            System.out.println("Moneda no encontrada");
            return false;
        }

        if (currencies.length == 1) {
            currency = currencies[0];
            return true;
        }

        if (currencies.length > 1) {
            System.out.println("Múltiples coincidencias para esa divisa: ");
            for (Currency curr : currencies)
                System.out.println(curr);
            return false;
        }

        return false;
    }
}