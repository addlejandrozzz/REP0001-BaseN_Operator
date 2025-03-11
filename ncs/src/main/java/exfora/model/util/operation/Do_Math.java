package exfora.model.util.operation;

import exfora.model.util.Base;

public enum Do_Math {
    PLUS {
        @Override
        public String between(Base base, String x, String y) {
            switch (base) {
                case BINARY -> {
                    return With_Base.PLUS_BINAR.operate(x, y);
                }
                case OCTAL -> {
                    return With_Base.PLUS_OCTAL.operate(x, y);
                }
                case HEXADECIMAL -> {
                    return With_Base.PLUS_HEXADECIMAL.operate(x, y);
                }
                case DECIMAL -> {
                    return String.valueOf(Integer.parseInt(x) + Integer.parseInt(y));
                }
                default -> {
                    throw new IllegalArgumentException("Invalid base");
                }
            }
        }
    },
    MINUS {
        @Override
        public String between(Base base, String x, String y) {
            switch (base) {
                case BINARY -> {
                    return With_Base.LESS_BINAR.operate(x, y);
                }
                case OCTAL -> {
                    return With_Base.LESS_OCTAL.operate(x, y);
                }
                case HEXADECIMAL -> {
                    return With_Base.LESS_HEXADECIMAL.operate(x, y);
                }
                case DECIMAL -> {
                    return String.valueOf(Integer.parseInt(x) - Integer.parseInt(y));
                }
                default -> {
                    throw new IllegalArgumentException("Invalid base");
                }
            }
        }
    },
    MULTIPLY {
        @Override
        public String between(Base base, String x, String y) {
            switch (base) {
                case BINARY -> {
                    return With_Base.MULT_BINAR.operate(x, y);
                }
                case OCTAL -> {
                    return With_Base.MULT_OCTAL.operate(x, y);
                }
                case HEXADECIMAL -> {
                    return With_Base.MULT_HEXAD.operate(x, y);
                }
                case DECIMAL -> {
                    return String.valueOf(Integer.parseInt(x) * Integer.parseInt(y));
                }
                default -> {
                    throw new IllegalArgumentException("Invalid base");
                }
            }
        }
    },
    DIVIDE {
        @Override
        public String between(Base base, String x, String y) {
            switch (base) {
                case BINARY -> {
                    return With_Base.DIVD_BINAR.operate(x, y);
                }
                case OCTAL -> {
                    return With_Base.DIVD_OCTAL.operate(x, y);
                }
                case HEXADECIMAL -> {
                    return With_Base.DIVD_HEXADECIMAL.operate(x, y);
                }
                case DECIMAL -> {
                    return String.valueOf(Integer.parseInt(x) / Integer.parseInt(y));
                }
                default -> {
                    throw new IllegalArgumentException("Invalid base");
                }
            }
        }
    };

    public abstract String between(Base base, String x, String y);
}
