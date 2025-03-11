package exfora.model.operators;

public class OctalOperator {
    
    public static String plus(String x, String y) {
        return Long.toOctalString(Long.parseLong(x, 8) + Long.parseLong(y, 8));
    }

    public static String minus(String x, String y) {
        return Long.toOctalString(Long.parseLong(x, 8) - Long.parseLong(y, 8));
    }

    public static String multiply(String x, String y) {
        return Long.toOctalString(Long.parseLong(x, 8) * Long.parseLong(y, 8));
    }

    public static String divide(String x, String y) {
        return Long.toOctalString(Long.parseLong(x, 8) / Long.parseLong(y, 8));
    }
}
