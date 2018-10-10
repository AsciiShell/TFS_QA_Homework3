public class ColumnPatronymicName extends AbstractColumnGender {
    private static String[] names;

    ColumnPatronymicName(Gender gender) {
        super(gender);
    }

    @Override
    protected void init() {
        if (names == null) {
            String surnamesFile = "Patronymics.txt";
            names = ResourceLoader.load(surnamesFile);
        }
    }

    @Override
    protected String generateValue(Gender gender) {
        return Rand.randomItem(names) + (gender == Gender.MALE ? "вич" : "вна");
    }
}
