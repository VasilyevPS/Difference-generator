import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    String path1 = "./src/test/resources/file1.json";
    String path2 = "./src/test/resources/file2.json";
    String pathEmpty = "./src/test/resources/emptyFile.json";
    @Test
    public void testJsonFiles() throws Exception {
        String result = Differ.generate(path1, path2);
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
    public void testEmptyJsonFiles() throws Exception {
        String result = Differ.generate(path1, pathEmpty);
        String expected = """
                {
                  - follow: false
                  - host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                }""";
        assertThat(result).isEqualTo(expected);
    }
}
