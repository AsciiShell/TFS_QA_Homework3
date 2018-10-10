public class ColumnZIP extends AbstractColumn {
    @Override
    protected void init() {

    }

    @Override
    protected Object generateValue() {
        StringBuilder sb = new StringBuilder(String.valueOf(Rand.randomInt(1, 9)));
        for (int i = 1; i < 6; i++) {
            sb.append(String.valueOf(Rand.randomInt(0, 9)));
        }
        return sb.toString();
    }
}
