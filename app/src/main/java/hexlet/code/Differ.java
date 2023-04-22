package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        
        Map<String, Object> data1 = getDiffData(filepath1);
        Map<String, Object> data2 = getDiffData(filepath2);

        return Formatter.chooseFormat(Comparator.compare(data1, data2), format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }


    private static Path getAbsolutePath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    private static String defineFileExtension(String filepath) {
        return filepath.substring(filepath.lastIndexOf('.') + 1).toLowerCase();
    }

    private static Map<String, Object> getDiffData(String filepath) throws Exception {
        Path path = getAbsolutePath(filepath);
        String content = Files.readString(path);
        String fileExtension = defineFileExtension(filepath);
        return Parser.parse(content, fileExtension);
    }
}
