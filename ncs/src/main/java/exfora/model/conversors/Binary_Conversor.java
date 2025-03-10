package exfora.model.conversors;

public class Binary_Conversor {
     public static String toOctal(String x) {
          long number = Long.parseLong(x);
          long octal = 0;
          int decimal = 0;
          int base = 1;
          while (number > 0) {
               long lastDigit = number % 10;
               if (lastDigit != 0 && lastDigit != 1) {
                    throw new IllegalArgumentException("El número no es binario.");
               }
               decimal += lastDigit * base;
               number /= 10;
               base *= 2;
          }
          long octalBase = 1;
          while (decimal > 0) {
               long remainder = decimal % 8;
               octal += remainder * octalBase;
               decimal /= 8;
               octalBase *= 10;
          }
          return String.valueOf(octal);
     }

     public static String toDecimal(String x) {
          long number = Long.parseLong(x);
          long decimal = 0, base = 1;
          while (number > 0) {
               long lastDigit = number % 10;
               number = number / 10;
               decimal += lastDigit * base;
               base = base * 2;
          }
          return String.valueOf(decimal);
     }

     public static String toHexadecimal(String x) {
          long number = Long.parseLong(x);
          long decimal = 0, base = 1;
          while (number > 0) {
               long lastDigit = number % 10;
               number = number / 10;
               decimal += lastDigit * base;
               base = base * 2;
          }
          StringBuilder hex = new StringBuilder();
          char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
          while (decimal > 0) {
               long remainder = decimal % 16;
               hex.insert(0, hexChars[(int) remainder]);
               decimal = decimal / 16;
          }
          return hex.toString();
     }
}
