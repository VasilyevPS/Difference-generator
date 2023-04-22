import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {

    private static final String PATH_FILE_1 = "./src/test/resources/file1.";
    private static final String PATH_FILE_2 = "./src/test/resources/file2.";

    private static String expectedResultStylish;
    private static String expectedResultPlain;
    private static String expectedResultJson;

    private static Path getAbsolutePath(String testResultFile) {
        return Paths.get("./src/test/resources/", testResultFile).toAbsolutePath().normalize();
    }

    private static String readFile(String testFile) throws Exception {
        Path testPath = getAbsolutePath(testFile);
        return Files.readString(testPath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        expectedResultJson = readFile("expectedResultJson.json");
        expectedResultStylish = readFile("expectedResultStylish.txt");
        expectedResultPlain = readFile("ExpectedResultPlain.txt");
    }

    @ParameterizedTest
    @ValueSource(strings = { "json", "yaml" })
    public void testDefault(String fileExtension) throws Exception {
        String result = Differ.generate(PATH_FILE_1 + fileExtension, PATH_FILE_2 + fileExtension);
        assertThat(result).isEqualToIgnoringWhitespace(expectedResultStylish);
    }

    @ParameterizedTest
    @ValueSource(strings = { "json", "yaml" })
    public void testStylish(String fileExtension) throws Exception {
        String result = Differ.generate(PATH_FILE_1 + fileExtension, PATH_FILE_2 + fileExtension, "stylish");
        assertThat(result).isEqualToIgnoringWhitespace(expectedResultStylish);
    }

    @ParameterizedTest
    @ValueSource(strings = { "json", "yaml" })
    public void testPlain(String fileExtension) throws Exception {
        String result = Differ.generate(PATH_FILE_1 + fileExtension, PATH_FILE_2 + fileExtension, "plain");
        assertThat(result).isEqualToIgnoringWhitespace(expectedResultPlain);
    }

    @ParameterizedTest
    @ValueSource(strings = { "json", "yaml" })
    public void testJson(String fileExtension) throws Exception {
        String result = Differ.generate(PATH_FILE_1 + fileExtension, PATH_FILE_2 + fileExtension, "json");
        assertThat(result).isEqualToIgnoringWhitespace(expectedResultJson);
    }

}
