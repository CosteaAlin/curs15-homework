package ro.fasttrackit.degrees;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DegreesConvertorTest {

    @Test
    @DisplayName("WHEN receiving a temperature in fahrenheit THEN return the temperature in celsius")
    void testFahrenheitToCelsius() {
        assertThat(DegreesConvertor.convertFahrenheitToCelsius(70)).isEqualTo(21.11);
    }

    @Test
    @DisplayName("WHEN receiving a temperature in celsius THEN return the temperature in fahrenheit")
    void testCelsiusToFahrenheit(){
        assertThat(DegreesConvertor.convertCelsiusToFahrenheit(21)).isEqualTo(69.80);
    }
}
