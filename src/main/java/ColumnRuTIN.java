public class ColumnRuTIN extends AbstractColumn {
    private static final int[] inspectionNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 33, 34, 35, 36, 43, 45, 46, 47, 48, 49, 50, 51};

    @Override
    protected void init() {

    }

    @Override
    protected Object generateValue() {
        // Look https://ru.wikipedia.org/wiki/Идентификационный_номер_налогоплательщика#Вычисление_контрольных_цифр for additional information
        int[] TIN = new int[12];
        TIN[0] = 7;
        TIN[1] = 7;
        int inspection = Rand.randomItem(inspectionNumbers);
        if (inspection < 10) {
            TIN[2] = 0;
            TIN[3] = inspection;
        } else {
            TIN[2] = inspection / 10;
            TIN[3] = inspection % 10;
        }
        for (int i = 4; i < 10; i++) {
            TIN[i] = Rand.randomInt(0, 9);
        }
        TIN[10] = ((7 * TIN[0] + 2 * TIN[1] + 4 * TIN[2] + 10 * TIN[3] + 3 * TIN[4] + 5 * TIN[5] + 9 * TIN[6] + 4 * TIN[7] + 6 * TIN[8] + 8 * TIN[9]) % 11) % 10;
        TIN[11] = ((3 * TIN[0] + 7 * TIN[1] + 2 * TIN[2] + 4 * TIN[3] + 10 * TIN[4] + 3 * TIN[5] + 5 * TIN[6] + 9 * TIN[7] + 4 * TIN[8] + 6 * TIN[9] + 8 * TIN[10]) % 11) % 10;
        StringBuilder sb = new StringBuilder();
        for (int aTIN : TIN) {
            sb.append(String.valueOf(aTIN));
        }
        return sb.toString();
    }
}
