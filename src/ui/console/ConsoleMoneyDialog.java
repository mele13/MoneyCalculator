package ui.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.Money;
import model.Number;
import ui.MoneyDialog;

public class ConsoleMoneyDialog implements MoneyDialog {

    private Money money;

    @Override
    public Money getMoney() {
        return money;
    }

    public void execute() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduzca la cantidad:");
            Number number = new Number(Double.valueOf(readAmount(reader)));
            ConsoleCurrencyDialog currency = new ConsoleCurrencyDialog();
            currency.execute();
            this.money = new Money(number, currency.getCurrency());
        } catch (IOException ex) {
        }
    }

    private String readAmount(BufferedReader reader) throws IOException {
        return reader.readLine();
    }
}