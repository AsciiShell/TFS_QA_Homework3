import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

class ResourceLoader {
    static String[] load(String fileName) {
        String fullName = NameColumn.class.getResource(fileName).getFile().substring(1);
        try {
            return Files.readAllLines(Paths.get(fullName), Charset.forName("UTF-8")).toArray(new String[0]);
        } catch (IOException e) {
            return new String[0];
        }
    }
}
