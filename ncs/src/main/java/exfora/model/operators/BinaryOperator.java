package exfora.model.operators;

public class BinaryOperator {
    public static String plus(String x, String y) {
        int maxLength = Math.max(x.length(), y.length());
        x = String.format("%" + maxLength + "s", x).replace(' ', '0');
        y = String.format("%" + maxLength + "s", y).replace(' ', '0');

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = maxLength - 1; i >= 0; i--) {
            int bit1 = x.charAt(i) - '0';
            int bit2 = y.charAt(i) - '0';
            int sum = bit1 + bit2 + carry;
            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            result.append(carry);
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
            int bit1 = x.charAt(i) - '0';
            int bit2 = y.charAt(i) - '0';
            int diff = bit1 - bit2 - borrow;
            if (diff < 0) {
                diff += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.append(diff);
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
                int bit1 = x.charAt(i) - '0';
                int bit2 = y.charAt(j) - '0';
                result[i + j + 1] += bit1 * bit2;
            }
        }

        for (int i = maxLength - 1; i > 0; i--) {
            result[i - 1] += result[i] / 2;
            result[i] %= 2;
        }

        StringBuilder resultStr = new StringBuilder();
        for (int bit : result) {
            resultStr.append(bit);
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

            if (compareBinary(remainder.toString(), y) >= 0) {
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

    private static int compareBinary(String x, String y) {
        if (x.length() != y.length()) {
            return x.length() - y.length();
        }
        return x.compareTo(y);
    }
}
