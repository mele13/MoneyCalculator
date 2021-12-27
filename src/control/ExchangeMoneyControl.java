package control;

import model.Currency;
import model.ExchangeRate;
import model.Money;
import model.MoneyExchanger;
import persistence.MockCurrencySetLoader;
import persistence.MockExchangeRateLoader;
import ui.console.ConsoleCurrencyDialog;
import ui.console.ConsoleMoneyDialog;
import ui.console.ConsoleMoneyViewer;

public class ExchangeMoneyControl {

    public void execute() {
        MockCurrencySetLoader.getInstance().load();
        Money money = readMoney();
        Currency currency = readCurrency();
        ExchangeRate exchangeRate = new MockExchangeRateLoader().load(money.getCurrency(), currency);
        System.out.println(money.getCurrency());
        new ConsoleMoneyViewer().show(MoneyExchanger.exchange(money, exchangeRate));
    }

    private Money readMoney() {
        ConsoleMoneyDialog dialog = new ConsoleMoneyDialog();
        dialog.execute();
        return dialog.getMoney();
    }

    private Currency readCurrency() {
        ConsoleCurrencyDialog dialog = new ConsoleCurrencyDialog();
        dialog.execute();
        return dialog.getCurrency();
    }
}
