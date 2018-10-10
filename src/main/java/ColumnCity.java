public class ColumnCity extends AbstractColumn {
    private static String[] cities;

    @Override
    protected Object generateValue() {
        return Rand.randomItem(cities);
    }

    @Override
    protected void init() {
        if (cities == null) {
            String citiesFile = "Cities.txt";
            cities = ResourceLoader.load(citiesFile);
        }
    }
}
