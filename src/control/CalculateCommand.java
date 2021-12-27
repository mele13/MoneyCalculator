package control;

import model.Currency;
import model.ExchangeRate;
import model.Money;
import model.MoneyExchanger;
import persistence.MockExchangeRateLoader;
import ui.CurrencyDialog;
import ui.MoneyDialog;
import ui.swing.MoneyDialogPanel;

public class CalculateCommand extends Command {

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.getMoney();
        Currency currency = currencyDialog.getCurrency();
        ExchangeRate exchangeRate = new MockExchangeRateLoader().load(money.getCurrency(), currency);
        Money result = MoneyExchanger.exchange(money, exchangeRate);
        MoneyDialogPanel.refresh(result.getAmount().toString());
    }
}
