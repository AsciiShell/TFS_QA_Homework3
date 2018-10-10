public class ColumnCountry extends AbstractColumn {
    private static String[] counties;

    @Override
    protected Object generateValue() {
        return Rand.randomItem(counties);
    }

    @Override
    protected void init() {
        if (counties == null) {
            String countriesFile = "Countries.txt";
            counties = ResourceLoader.load(countriesFile);
        }
    }
}
