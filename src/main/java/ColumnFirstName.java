public class ColumnFirstName extends AbstractColumnGender {
    private static String[] namesMale;
    private static String[] namesFemale;

    ColumnFirstName(Gender gender) {
        super(gender);
    }

    @Override
    protected void init() {
        if (namesMale == null || namesFemale == null) {
            String namesMaleFile = "FirstNameMale.txt";
            String namesFemaleFile = "FirstNameFemale.txt";
            namesMale = ResourceLoader.load(namesMaleFile);
            namesFemale = ResourceLoader.load(namesFemaleFile);
        }
    }

    @Override
    protected String generateValue(Gender gender) {
        return (String) Rand.randomItem(gender == Gender.MALE ? namesMale : namesFemale);
    }

}
