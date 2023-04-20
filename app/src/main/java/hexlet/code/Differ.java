package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        Path path1 = getAbsolutePath(filepath1);
        Path path2 = getAbsolutePath(filepath2);

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        String fileExtension1 = defineFileExtension(filepath1);
        String fileExtension2 = defineFileExtension(filepath2);

        Map<String, Object> data1 = Parser.parse(content1, fileExtension1);
        Map<String, Object> data2 = Parser.parse(content2, fileExtension2);

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
}
