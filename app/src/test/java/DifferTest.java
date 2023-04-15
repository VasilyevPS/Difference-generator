import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    String pathJson1 = "./src/test/resources/file1.json";
    String pathJson2 = "./src/test/resources/file2.json";
    String pathYaml1 = "./src/test/resources/file1.yaml";
    String pathYaml2 = "./src/test/resources/file2.yaml";

    @Test
    public void testJsonFiles() throws Exception {
        String result = Differ.generate(pathJson1, pathJson2);
        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void testYamlFiles() throws Exception {
        String result = Differ.generate(pathYaml1, pathYaml2);
        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        assertThat(result).isEqualTo(expected);
    }
}
