package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Comparator {
    public static String compare(Map<String, Object> data1, Map<String, Object> data2) {
        StringBuilder result = new StringBuilder("{"  + "\n");
        Set<String> keys = new TreeSet<>();
        keys.addAll(data1.keySet());
        keys.addAll(data2.keySet());
        for (String key: keys) {

            if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
            } else if (!data1.get(key).equals(data2.get(key))) {
                result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            } else {
                result.append("    ").append(key).append(": ").append(data1.get(key)).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
