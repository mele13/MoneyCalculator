package ui.console;

import model.Money;
import ui.MoneyViewer;

public class ConsoleMoneyViewer implements MoneyViewer {

    @Override
    public void show(Money money) {
        System.out.println("Resultado: " + (double) (money.getAmount().getNumerator()
                / money.getAmount().getDenominator())
                + " " + money.getCurrency().getSymbol());
    }
}