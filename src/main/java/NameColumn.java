import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NameColumn {
    private String name;
    private static String[] namesMale;
    private static String[] namesFemale;

    public NameColumn(Gender gender) {
        init();
        if (gender == Gender.MALE) {
            name = Rand.RandomItem(namesMale);
        } else {
            name = Rand.RandomItem(namesFemale);
        }
    }

    private static void init() {
        if (namesMale == null || namesFemale == null) {
            String namesMaleFile = "FirstNameMale.txt";
            String namesFemaleFile = "FirstNameFemale.txt";
            namesMale = loadData(namesMaleFile);
            namesFemale = loadData(namesFemaleFile);
        }
    }

    private static String[] loadData(String fileName) {
        String fullName = NameColumn.class.getResource(fileName).getFile().substring(1);
        try {
            return Files.readAllLines(Paths.get(fullName), Charset.forName("UTF-8")).toArray(new String[0]);
        } catch (IOException e) {
            return new String[0];
        }

    }

    public String getName() {
        return name;
    }
}
