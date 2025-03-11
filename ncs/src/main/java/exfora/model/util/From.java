package exfora.model.util;

public enum From {

     BIN {
          @Override
          public String converseTo(Base base, String number) {
               switch (base) {
                    case BINARY:
                         return number;
                    case OCTAL:
                         return To.B_OCTAL.convert(number);
                    case DECIMAL:
                         return To.B_DECIMAL.convert(number);
                    case HEXADECIMAL:
                         return To.B_HEXADECIMAL.convert(number);
               }
               throw new IllegalArgumentException("Invalid base for BIN: " + base);
          }
     },
     OCT {
          @Override
          public String converseTo(Base base, String number) {
               switch (base) {
                    case BINARY:
                         return To.O_BINARY.convert(number);
                    case OCTAL:
                         return number;
                    case DECIMAL:
                         return To.O_DECIMAL.convert(number);
                    case HEXADECIMAL:
                         return To.O_HEXADECIMAL.convert(number);
               }
               throw new IllegalArgumentException("Invalid base for OCT: " + base);
          }
     },
     DEC {
          @Override
          public String converseTo(Base base, String number) {
               switch (base) {
                    case BINARY:
                         return To.D_BINARY.convert(number);
                    case OCTAL:
                         return To.D_OCTAL.convert(number);
                    case DECIMAL:
                         return number;
                    case HEXADECIMAL:
                         return To.D_HEXADECIMAL.convert(number);
               }
               throw new IllegalArgumentException("Invalid base for DEC: " + base);
          }
     },
     HEX {
          @Override
          public String converseTo(Base base, String number) {
               switch (base) {
                    case BINARY:
                         return To.H_BINARY.convert(number);
                    case OCTAL:
                         return To.H_OCTAL.convert(number);
                    case DECIMAL:
                         return To.H_DECIMAL.convert(number);
                    case HEXADECIMAL:
                         return number;
               }
               throw new IllegalArgumentException("Invalid base for HEX: " + base);
          }
     };

     abstract String converseTo(Base base, String number);
}
