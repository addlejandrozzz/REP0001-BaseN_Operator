package exfora.model.util.operation;

import exfora.model.operators.BinaryOperator;
import exfora.model.operators.HexadOperator;
import exfora.model.operators.OctalOperator;

public enum With_Base {
    PLUS_BINAR {
        @Override
        public String operate(String x, String y) {
            return BinaryOperator.plus(x, y);
        }
    },
    PLUS_OCTAL {
        @Override
        public String operate(String x, String y) {
            return OctalOperator.plus(x, y);
        }
    },
    PLUS_HEXADECIMAL {
        @Override
        public String operate(String x, String y) {
            return HexadOperator.plus(x, y);
        }
    },
    LESS_BINAR {
        @Override
        public String operate(String x, String y) {
            return BinaryOperator.minus(x, y);
        }
    },
    LESS_OCTAL {
        @Override
        public String operate(String x, String y) {
            return OctalOperator.minus(x, y);
        }
    },
    LESS_HEXADECIMAL {
        @Override
        public String operate(String x, String y) {
            return HexadOperator.minus(x, y);
        }
    },
    MULT_BINAR {
        @Override
        public String operate(String x, String y) {
            return BinaryOperator.multiply(x, y);
        }
    },
    MULT_OCTAL {
        @Override
        public String operate(String x, String y) {
            return OctalOperator.multiply(x, y);
        }
    },
    MULT_HEXAD {
        @Override
        public String operate(String x, String y) {
            return HexadOperator.multiply(x, y);
        }
    },
    DIVD_BINAR {
        @Override
        public String operate(String x, String y) {
            return BinaryOperator.divide(x, y);
        }
    },
    DIVD_OCTAL {
        @Override
        public String operate(String x, String y) {
            return OctalOperator.divide(x, y);
        }
    },
    DIVD_HEXADECIMAL {
        @Override
        public String operate(String x, String y) {
            return HexadOperator.divide(x, y);
        }
    };

    public abstract String operate(String x, String y);
}
