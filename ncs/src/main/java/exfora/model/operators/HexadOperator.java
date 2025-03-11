package exfora.model.operators;

public class HexadOperator {

    public static String plus(String x, String y) {
        int maxLength = Math.max(x.length(), y.length());
        x = String.format("%" + maxLength + "s", x).replace(' ', '0');
        y = String.format("%" + maxLength + "s", y).replace(' ', '0');

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int digit1 = Character.digit(x.charAt(i), 16);
            int digit2 = Character.digit(y.charAt(i), 16);
            int sum = digit1 + digit2 + carry;
            result.append(Integer.toHexString(sum % 16));
            carry = sum / 16;
        }

        if (carry != 0) {
            result.append(Integer.toHexString(carry));
        }

        return result.reverse().toString();
    }

    public static String minus(String x, String y) {
        int maxLength = Math.max(x.length(), y.length());
        x = String.format("%" + maxLength + "s", x).replace(' ', '0');
        y = String.format("%" + maxLength + "s", y).replace(' ', '0');

        StringBuilder result = new StringBuilder();
        int borrow = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int digit1 = Character.digit(x.charAt(i), 16);
            int digit2 = Character.digit(y.charAt(i), 16);
            int diff = digit1 - digit2 - borrow;
            if (diff < 0) {
                diff += 16;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.append(Integer.toHexString(diff));
        }

        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.setLength(result.length() - 1);
        }

        return result.reverse().toString();
    }

    public static String multiply(String x, String y) {
        int maxLength = x.length() + y.length();
        int[] result = new int[maxLength];

        for (int i = x.length() - 1; i >= 0; i--) {
            for (int j = y.length() - 1; j >= 0; j--) {
                int digit1 = Character.digit(x.charAt(i), 16);
                int digit2 = Character.digit(y.charAt(j), 16);
                result[i + j + 1] += digit1 * digit2;
            }
        }

        for (int i = maxLength - 1; i > 0; i--) {
            result[i - 1] += result[i] / 16;
            result[i] %= 16;
        }

        StringBuilder resultStr = new StringBuilder();
        for (int digit : result) {
            resultStr.append(Integer.toHexString(digit));
        }

        while (resultStr.length() > 1 && resultStr.charAt(0) == '0') {
            resultStr.deleteCharAt(0);
        }

        return resultStr.toString();
    }

    public static String divide(String x, String y) {
        if (y.equals("0")) {
            throw new ArithmeticException("Division by zero");
        }

        StringBuilder quotient = new StringBuilder();
        StringBuilder remainder = new StringBuilder();

        for (int i = 0; i < x.length(); i++) {
            remainder.append(x.charAt(i));
            if (remainder.length() > 1 && remainder.charAt(0) == '0') {
                remainder.deleteCharAt(0);
            }

            if (compareHex(remainder.toString(), y) >= 0) {
                quotient.append('1');
                remainder = new StringBuilder(minus(remainder.toString(), y));
            } else {
                quotient.append('0');
            }
        }

        while (quotient.length() > 1 && quotient.charAt(0) == '0') {
            quotient.deleteCharAt(0);
        }

        return quotient.toString();
    }

    private static int compareHex(String x, String y) {
        if (x.length() != y.length()) {
            return x.length() - y.length();
        }
        return x.compareTo(y);
    }
}
