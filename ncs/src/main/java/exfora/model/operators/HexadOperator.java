package exfora.model.operators;

public class HexadOperator {
    
    public static String plus(String x, String y) {
        return Long.toHexString(Long.parseLong(x, 16) + Long.parseLong(y, 16));
    }

    public static String minus(String x, String y) {
        return Long.toHexString(Long.parseLong(x, 16) - Long.parseLong(y, 16));
    }

    public static String multiply(String x, String y) {
        return Long.toHexString(Long.parseLong(x, 16) * Long.parseLong(y, 16));
    }

    public static String divide(String x, String y) {
        return Long.toHexString(Long.parseLong(x, 16) / Long.parseLong(y, 16));
    }
}
