package exfora.model.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import exfora.model.util.convertion.From;
import exfora.model.util.operation.Do_Math;

public class NumberGuardian {

     static Pattern pat_binary = Pattern.compile("^[01]+$", Pattern.CASE_INSENSITIVE);
     static Pattern pat_octal = Pattern.compile("^[0-7]+$", Pattern.CASE_INSENSITIVE);
     static Pattern pat_decimal = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE);
     static Pattern pat_hexadecimal = Pattern.compile("^[0-9A-F]+$", Pattern.CASE_INSENSITIVE);
     static final int MAX_LENGTH = 19;

     public static String passConverse(Base baseIn, Base baseOut, String number) throws IllegalArgumentException {
          if (number.length() < MAX_LENGTH) {
               if (checkNumber(baseIn, number)) {
                    switch (baseIn) {
                         case BINARY -> {
                              return From.BIN.converseTo(baseOut, number);
                         }
                         case OCTAL -> {
                              return From.OCT.converseTo(baseOut, number);
                         }
                         case DECIMAL -> {
                              return From.DEC.converseTo(baseOut, number);
                         }
                         case HEXADECIMAL -> {
                              return From.HEX.converseTo(baseOut, number);
                         }
                    }
               }
               return "Invalid number for selected base";
          }
          return "Number exceeds the maximum length admited";
     }

     public static String passOperation(Base baseIn, String x, String y, Operation operation) {
          if (x.length() < MAX_LENGTH && y.length() < MAX_LENGTH) {
               if (checkNumber(baseIn, x) && checkNumber(baseIn, y)) {
                    switch (operation) {
                         case PLUS -> {
                              return Do_Math.PLUS.between(baseIn, x, y);
                         }
                         case MINUS -> {
                              return Do_Math.MINUS.between(baseIn, x, y);
                         }
                         case MULTIPLY -> {
                              return Do_Math.MULTIPLY.between(baseIn, x, y);
                         }
                         case DIVIDE -> {
                              return Do_Math.DIVIDE.between(baseIn, x, y);
                         }
                    }
               }
               return "One of your numbers is invalid number for selected base";
          }
          return "One of the numbers exceeds the maximum length for a long value.";

     }

     // Check if the number is valid
     private static boolean checkNumber(Base baseIn, String number) {
          switch (baseIn) {
               case BINARY -> {
                    return isBinary(number);
               }
               case OCTAL -> {
                    return isOctal(number);
               }
               case DECIMAL -> {
                    return isDecimal(number);
               }
               case HEXADECIMAL -> {
                    return isHexadecimal(number);
               }
               default -> {
                    return false;
               }
          }
     }

     private static boolean isBinary(String number) {
          Matcher matcher = pat_binary.matcher(number);
          return matcher.find();
     }

     private static boolean isOctal(String number) {
          Matcher matcher = pat_octal.matcher(number);
          return matcher.find();
     }

     private static boolean isDecimal(String number) {
          Matcher matcher = pat_decimal.matcher(number);
          return matcher.find();
     }

     private static boolean isHexadecimal(String number) {
          Matcher matcher = pat_hexadecimal.matcher(number);
          return matcher.find();
     }
}
