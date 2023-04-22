package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String convertResult(List<Map<String, Object>> diffData) {
        StringBuilder result = new StringBuilder();
        for (Map<String, Object> keyDiff: diffData) {
            switch (keyDiff.get("status").toString()) {
                case ("added") -> result.append("Property '")
                        .append(keyDiff.get("key"))
                        .append("' was added with value: ")
                        .append(defineValue(keyDiff.get("newValue")))
                        .append("\n");
                case ("removed") -> result.append("Property '")
                        .append(keyDiff.get("key"))
                        .append("' was removed\n");
                case ("updated") -> result.append("Property '")
                        .append(keyDiff.get("key"))
                        .append("' was updated. From ")
                        .append(defineValue(keyDiff.get("oldValue")))
                        .append(" to ")
                        .append(defineValue(keyDiff.get("newValue")))
                        .append("\n");
                default -> { }
            }
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private static String defineValue(Object value) {
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return String.valueOf(value);
        }
    }
}
