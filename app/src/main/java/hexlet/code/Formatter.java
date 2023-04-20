package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;


public class Formatter {
    public static String chooseFormat(List<Map<String, Object>> diffData, String format) throws Exception {
        return switch (format) {
            case ("stylish") -> Stylish.convertResult(diffData);
            case ("plain") -> Plain.convertResult(diffData);
            default -> throw new Exception("Unknown format " + format);
        };
    }
}
