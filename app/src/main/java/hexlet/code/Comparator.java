package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Comparator {
    public static List<Map<String, Object>> compare(Map<String, Object> data1, Map<String, Object> data2) {
        List<Map<String, Object>> result = new ArrayList<>();
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        for (String key: keys) {
            Map<String, Object> keyDiff = new LinkedHashMap<>();
            keyDiff.put("key", key);
            if (!data1.containsKey(key) && data2.containsKey(key)) {
                keyDiff.put("status", "added");
                keyDiff.put("newValue", data2.get(key));
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                keyDiff.put("status", "removed");
                keyDiff.put("oldValue", data1.get(key));
            } else if (!Objects.equals(data1.get(key), data2.get(key))) {
                keyDiff.put("status", "updated");
                keyDiff.put("oldValue", data1.get(key));
                keyDiff.put("newValue", data2.get(key));
            } else {
                keyDiff.put("status", "unchanged");
                keyDiff.put("oldValue", data1.get(key));
            }
            result.add(keyDiff);
        }
        return result;
    }
}
