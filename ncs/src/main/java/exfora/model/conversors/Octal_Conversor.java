package exfora.model.conversors;

public class Octal_Conversor {
    public static String toBinary(String x) {
        int decimal = Integer.parseInt(toDecimal(x));
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            binary.insert(0, decimal % 2);
            decimal = decimal / 2;
        }
        return binary.toString();
    }

    public static String toDecimal(String x) {
        int decimal = 0;
        int length = x.length();
        for (int i = 0; i < length; i++) {
            char c = x.charAt(length - 1 - i);
            int digit = Character.getNumericValue(c);
            decimal += digit * Math.pow(8, i);
        }
        return String.valueOf(decimal);
    }

    public static String toHexadecimal(String x) {
        int decimal = Integer.parseInt(toDecimal(x));
        StringBuilder hexadecimal = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 16;
            if (remainder < 10) {
                hexadecimal.insert(0, (char) ('0' + remainder));
            } else {
                hexadecimal.insert(0, (char) ('A' + (remainder - 10)));
            }
            decimal = decimal / 16;
        }
        return hexadecimal.toString();
    }
}
