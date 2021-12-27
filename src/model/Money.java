package model;

public class Money {

    private final Number amount;
    private final Currency currency;

    public Money(Number amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Number getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Money{" + "amount = " + amount + ", currency = " + currency + '}';
    }

}
