package app.domain;

public class Money {
    private final int amount;

    public Money() {
        this(0);
    }

    public Money(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
