public class ColumnRegion extends AbstractColumn {
    private static String[] regions;

    @Override
    protected Object generateValue() {
        return Rand.randomItem(regions);
    }

    @Override
    protected void init() {
        if (regions == null) {
            String regionsFile = "Regions.txt";
            regions = ResourceLoader.load(regionsFile);
        }
    }
}
