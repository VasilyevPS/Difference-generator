package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {

    public static String convertResult(List<Map<String, Object>> diffData) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> keyDiff: diffData) {
            switch (keyDiff.get("status").toString()) {
                case ("added") -> result.append(createResultString("  + ", keyDiff, "newValue"));
                case ("removed") -> result.append(createResultString("  - ", keyDiff, "oldValue"));
                case ("updated") -> {
                    result.append(createResultString("  - ", keyDiff, "oldValue"));
                    result.append(createResultString("  + ", keyDiff, "newValue")); }
                case ("unchanged") -> result.append(createResultString("    ", keyDiff, "oldValue"));
                default -> { }
            }
        }
        result.append("}");
        return result.toString();
    }

    private static String createResultString(String sign, Map<String, Object> keyDiff, String value) {
        return sign + keyDiff.get("key") + ": " + keyDiff.get(value) + "\n";
    }
}
