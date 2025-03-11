package exfora.model.conversors;

public class Hexa_Conversor {
    public static String toBinary(String x) {
        long number = Long.parseLong(x, 16);
        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            binary.insert(0, number % 2);
            number = number / 2;
        }
        return binary.toString();
    }

    public static String toOctal(String x) {
        long number = Long.parseLong(x, 16);
        StringBuilder octal = new StringBuilder();
        while (number > 0) {
            octal.insert(0, number % 8);
            number = number / 8;
        }
        return octal.toString();
    }

    public static String toDecimal(String x) {
        long number = 0;
        for (int i = 0; i < x.length(); i++) {
            char hexChar = x.charAt(i);
            int decimalValue = Character.digit(hexChar, 16);
            number = number * 16 + decimalValue;
        }
        return Long.toString(number);
    }
}
