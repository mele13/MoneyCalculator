package model;

import java.util.Date;

public class ExchangeRate {

    private Currency from, to;
    private Number rate;
    private Date date;

    public ExchangeRate(Date date, Currency from, Currency to, Number rate) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.rate = rate;
    }

    public ExchangeRate(Currency from, Currency to, Number rate) {
        this(new Date(), from, to, rate);
    }

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public Number getRate() {
        return rate;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" + "from=" + from + ", to=" + to + ", rate=" + rate + '}';
    }
}
