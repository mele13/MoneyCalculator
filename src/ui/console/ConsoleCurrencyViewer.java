package ui.console;

import model.Currency;
import ui.CurrencyViewer;

public class ConsoleCurrencyViewer implements CurrencyViewer {

    private final Currency currency;

    public ConsoleCurrencyViewer(Currency currency) {
        this.currency = currency;
    }

    @Override
    public void show() {
        System.out.println(currency.getSymbol());
    }
}