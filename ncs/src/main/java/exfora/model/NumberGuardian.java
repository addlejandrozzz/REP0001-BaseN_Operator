package exfora.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import exfora.model.util.Base;

public class NumberGuardian {

     static Pattern pat_binary = Pattern.compile("^[01]+$", Pattern.CASE_INSENSITIVE);
     static Pattern pat_octal = Pattern.compile("^[0-7]+$", Pattern.CASE_INSENSITIVE);
     static Pattern pat_decimal = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE);
     static Pattern pat_hexadecimal = Pattern.compile("^[0-9A-F]+$", Pattern.CASE_INSENSITIVE);

     public static String passNumber(Base baseIn, Base baseOut, String number) throws IllegalArgumentException {
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
          throw new IllegalArgumentException("Invalid number for selected base");
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
