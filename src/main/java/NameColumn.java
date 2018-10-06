public class NameColumn {
    private String name;
    private static String[] namesMale;
    private static String[] namesFemale;

    NameColumn(Gender gender) {
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
            namesMale = ResourceLoader.load(namesMaleFile);
            namesFemale = ResourceLoader.load(namesFemaleFile);
        }
    }

    public String getName() {
        return name;
    }
}
