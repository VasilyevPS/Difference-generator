import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    String pathJson1 = "./src/test/resources/file1.json";
    String pathJson2 = "./src/test/resources/file2.json";
    String pathYaml1 = "./src/test/resources/file1.yaml";
    String pathYaml2 = "./src/test/resources/file2.yaml";
    private static String expectedResultStylish;

    private static String expectedResultPlain;

    private static String expectedResultJson;

    private static Path getAbsolutePath(String testResultFile) {
        return Paths.get("./src/test/resources/", testResultFile).toAbsolutePath().normalize();
    }
    private static String readTestResults(String testFile) throws Exception {
        Path testPath = getAbsolutePath(testFile);
        return Files.readString(testPath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        expectedResultJson = readTestResults("expectedResultJson.json");
        expectedResultStylish = readTestResults("expectedResultStylish.txt");
        expectedResultPlain = readTestResults("ExpectedResultPlain.txt");
    }

    @Test
    public void testJsonFiles() throws Exception {
        String result = Differ.generate(pathJson1, pathJson2);
        assertThat(result).isEqualToIgnoringWhitespace(expectedResultStylish);
    }
    @Test
    public void testYamlFiles() throws Exception {
        String result = Differ.generate(pathYaml1, pathYaml2);
        assertThat(result).isEqualToIgnoringWhitespace(expectedResultStylish);
    }

    @Test
    public void testJsonFilesPlain() throws Exception {
        String result = Differ.generate(pathJson1, pathJson2, "plain");
        assertThat(result).isEqualToIgnoringWhitespace(expectedResultPlain);
    }

    @Test
    public void testYamlFilesPlain() throws Exception {
        String result = Differ.generate(pathYaml1, pathYaml2, "plain");
        assertThat(result).isEqualToIgnoringWhitespace(expectedResultPlain);
    }

    @Test
    public void testJsonFilesJson() throws Exception {
        String result = Differ.generate(pathJson1, pathJson2, "json");
        assertThat(result).isEqualTo(expectedResultJson);
    }

    @Test
    public void testYamlFilesJson() throws Exception {
        String result = Differ.generate(pathYaml1, pathYaml2, "json");
        assertThat(result).isEqualTo(expectedResultJson);
    }
}
