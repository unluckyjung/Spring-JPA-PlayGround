package app.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    void amountTest() {
        Money money = new Money(100);
        assertThat(money.getAmount()).isEqualTo(100);
    }

    @Test
    void basicAmountTest() {
        Money money = new Money();
        assertThat(money.getAmount()).isEqualTo(0);
    }
}