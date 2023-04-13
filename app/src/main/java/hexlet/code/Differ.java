package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {

        Path path1 = getAbsolutePath(filepath1);
        Path path2 = getAbsolutePath(filepath2);

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        Map<String, Object> data1 = Parser.parse(content1);
        Map<String, Object> data2 = Parser.parse(content2);

        return Comparator.compare(data1, data2);
    }
    private static Path getAbsolutePath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }
}
