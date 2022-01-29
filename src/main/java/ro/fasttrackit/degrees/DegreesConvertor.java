package ro.fasttrackit.degrees;

public class DegreesConvertor {

    public static double convertFahrenheitToCelsius(double temperature) {
        return Math.round((temperature - 32) * 5 / 9 * 100.0) / 100.0;
    }

    public static double convertCelsiusToFahrenheit(double temperature) {
        return Math.round(((temperature * 9 / 5) + 32) * 100.0) / 100.0;
    }
}
