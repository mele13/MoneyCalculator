package model;

public class Number {
    private long numerator;
    private long denominator;

    public Number(long numerator, long denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        simplify();
    }

    public Number(Number number) {
        this(number.numerator, number.denominator);
    }

    public Number(int number) {
        this(number, 1);
    }

    public Number(long number) {
        this(number, 1);
    }

    public Number(double number) {
        this(fromDouble(number));
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public static Number fromDouble(double number) {
        int denominator = 1;
        while ((long) number != number) {
            number *= 10;
            denominator *= 10;
        }
        return new Number((long) number, denominator);
    }

    private void simplify() {
        PrimeCollection primeCollection = new PrimeCollection();
        for (long prime : primeCollection) {
            if (numerator < prime || denominator < prime)
                break;
            reduce(prime);
        }
    }

    private void reduce(long prime) {
        while (isDivisible(prime)) {
            numerator /= prime;
            denominator /= prime;
        }
    }

    public Number add(Number number) {
        long numerator;
        long denominator;

        denominator = this.denominator * number.denominator;
        numerator = ((denominator / this.denominator) * this.numerator)
                + ((denominator / number.denominator) * number.numerator);

        return new Number(numerator, denominator);
    }

    public Number substract(Number number) {
        long numerator;
        long denominator;

        denominator = this.denominator * number.denominator;
        numerator = ((denominator / this.denominator) * this.numerator)
                - ((denominator / number.denominator) * number.numerator);

        return new Number(numerator, denominator);
    }

    public Number multiply(Number number) {
        return new Number(this.numerator * number.numerator,
                this.denominator * number.denominator);
    }

    public Number divide(Number number) {
        return new Number(this.numerator * number.denominator,
                this.denominator * number.numerator);
    }

    private boolean isDivisible(long prime) {
       return (numerator % prime == 0 && denominator % prime == 0);        
    }

    @Override
    public String toString() {
        return Double.toString((double) numerator / (double) denominator);
    }
}
