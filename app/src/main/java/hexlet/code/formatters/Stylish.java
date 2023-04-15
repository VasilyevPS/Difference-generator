package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    private static StringBuilder result;
    public static String convertResult(List<Map<String, Object>> diffData) {
        result = new StringBuilder("{\n");
        for (Map<String, Object> keyDiff: diffData) {
            switch (keyDiff.get("status").toString()) {
                case ("added") -> createResultString("  + ", keyDiff, "newValue");
                case ("removed") -> createResultString("  - ", keyDiff, "oldValue");
                case ("updated") -> {
                    createResultString("  - ", keyDiff, "oldValue");
                    createResultString("  + ", keyDiff, "newValue"); }
                case ("unchanged") -> createResultString("    ", keyDiff, "oldValue");
                default -> { }
            }
        }
        result.append("}");
        return result.toString();
    }

    private static void createResultString(String sign, Map<String, Object> keyDiff, String value) {
        result.append(sign)
                .append(keyDiff.get("key"))
                .append(": ")
                .append(keyDiff.get(value))
                .append("\n");
    }
}
