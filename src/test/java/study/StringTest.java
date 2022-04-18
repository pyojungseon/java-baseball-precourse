package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("String split with ',' return only values")
    public void splitStringTest() {
        String input = "1,2";
        String[] testValues = input.split(",");
        assertThat(testValues).containsExactly("1", "2");

        input = "1";
        testValues = input.split(",");
        assertThat(testValues).containsExactly("1");
    }

    @Test
    @DisplayName("Substring with index, remove only ()")
    public void subStringTest() {
        String input = "(1,2)";
        String testValues = input.substring(1, 4);
        assertThat(testValues).contains("1,2");
    }

    @Test
    @DisplayName("Approach out of bound index, throw exception")
    public void outOfBoundTest() {
        String input="abc";
        assertThatThrownBy(() -> input.charAt(4))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
}
