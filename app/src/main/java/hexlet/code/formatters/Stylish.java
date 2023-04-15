package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String convertResult(List<Map<String, Object>> diffData) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> keyDiff: diffData) {
            switch (keyDiff.get("status").toString()) {
                case ("added") ->
                        result.append("  + ")
                                .append(keyDiff.get("key"))
                                .append(": ")
                                .append(keyDiff.get("newValue"))
                                .append("\n");
                case ("deleted") ->
                        result.append("  - ")
                                .append(keyDiff.get("key"))
                                .append(": ")
                                .append(keyDiff.get("oldValue"))
                                .append("\n");
                case ("changed") -> {
                    result.append("  - ")
                        .append(keyDiff.get("key"))
                        .append(": ")
                        .append(keyDiff.get("oldValue"))
                        .append("\n");
                    result.append("  + ")
                            .append(keyDiff.get("key"))
                            .append(": ")
                            .append(keyDiff.get("newValue"))
                            .append("\n"); }
                case ("unchanged") ->
                        result.append("    ")
                                .append(keyDiff.get("key"))
                                .append(": ")
                                .append(keyDiff.get("oldValue"))
                                .append("\n");
                default -> { }
            }
        }
        result.append("}");
        return result.toString();
    }
}
