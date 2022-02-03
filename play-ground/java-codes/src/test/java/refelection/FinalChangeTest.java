package refelection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalChangeTest {
    @Test
    void test() {
        Name name = new Name("jys");

        try {
            Class clazz = Name.class;
            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);
            field.set(name, "unluckyjung");

            assertThat(name.getValue()).isEqualTo("unluckyjung");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Name {
    private final String value;

    Name(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}