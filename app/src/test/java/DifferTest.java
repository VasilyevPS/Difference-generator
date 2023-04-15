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
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void testYamlFiles() throws Exception {
        String result = Differ.generate(pathYaml1, pathYaml2);
        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        assertThat(result).isEqualTo(expected);
    }
}
