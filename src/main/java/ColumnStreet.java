public class ColumnStreet extends AbstractColumn {
    private static String[] streets;

    @Override
    protected Object generateValue() {
        return Rand.randomItem(streets);
    }

    @Override
    protected void init() {
        if (streets == null) {
            String streetsFile = "Streets.txt";
            streets = ResourceLoader.load(streetsFile);
        }
    }
}
