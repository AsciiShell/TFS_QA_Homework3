public class ColumnSecondName extends AbstractColumnGender {
    private static String[] names;

    ColumnSecondName(Gender gender) {
        super(gender);
    }

    @Override
    protected void init() {
        if (names == null) {
            String surnamesFile = "Surnames.txt";
            names = ResourceLoader.load(surnamesFile);
        }
    }

    @Override
    protected String generateValue(Gender gender) {
        return Rand.randomItem(names) + (gender == Gender.FEMALE ? "a" : "");
    }

}
