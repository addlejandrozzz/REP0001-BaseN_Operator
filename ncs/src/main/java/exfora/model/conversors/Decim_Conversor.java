package exfora.model.conversors;

public class Decim_Conversor {
    public static String toBinary(String x) {
        long number = Long.parseLong(x);
        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            binary.insert(0, number % 2);
            number /= 2;
        }
        return binary.toString();
    }

    public static String toOctal(String x) {
        long number = Long.parseLong(x);
        StringBuilder octal = new StringBuilder();
        while (number > 0) {
            octal.insert(0, number % 8);
            number /= 8;
        }
        return octal.toString();
    }

    public static String toHexadecimal(String x) {
        long number = Long.parseLong(x);
        StringBuilder hex = new StringBuilder();
        while (number > 0) {
            long remainder = number % 16;
            if (remainder < 10) {
                hex.insert(0, remainder);
            } else {
                hex.insert(0, (char) ('A' + (remainder - 10)));
            }
            number /= 16;
        }
        return hex.toString();
    }
}
