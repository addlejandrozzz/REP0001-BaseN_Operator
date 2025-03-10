package exfora.model;

import exfora.model.conversors.Binary_Conversor;
import exfora.model.conversors.Decim_Conversor;
import exfora.model.conversors.Hexa_Conversor;
import exfora.model.conversors.Octal_Conversor;

public enum To {
     B_OCTAL {

          String convert(String number) {
               return Binary_Conversor.toOctal(number);
          }

     },
     B_DECIMAL {

          String convert(String number) {
               return Binary_Conversor.toDecimal(number);
          }

     },
     B_HEXADECIMAL {

          String convert(String number) {
               return Binary_Conversor.toHexadecimal(number);
          }

     },
     D_BINARY {

          String convert(String number) {
               return Decim_Conversor.toBinary(number);
          }

     },
     D_OCTAL {

          String convert(String number) {
               return Decim_Conversor.toOctal(number);
          }

     },
     D_HEXADECIMAL {

          String convert(String number) {
               return Decim_Conversor.toHexadecimal(number);
          }

     },
     O_BINARY {

          String convert(String number) {
               return Octal_Conversor.toBinary(number);
          }

     },
     O_DECIMAL {

          String convert(String number) {
               return Octal_Conversor.toDecimal(number);
          }

     },
     O_HEXADECIMAL {

          String convert(String number) {
               return Octal_Conversor.toHexadecimal(number);
          }

     },
     H_BINARY {

          String convert(String number) {
               return Hexa_Conversor.toBinary(number);
          }

     },
     H_OCTAL {

          String convert(String number) {
               return Hexa_Conversor.toOctal(number);
          }

     },
     H_DECIMAL {

          String convert(String number) {
               return Hexa_Conversor.toDecimal(number);
          }

     };

     abstract String convert(String number);
}
