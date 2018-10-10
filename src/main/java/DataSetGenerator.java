import java.io.File;
import java.io.IOException;

public class DataSetGenerator {
    public static void main(String[] args) throws IOException {
        String filename = "test.xlsx";
        DataStorageExcel storageExcel = new DataStorageExcel(filename);
        int items = Rand.randomInt(1, 30);
        for (int i = 0; i < items; i++) {
            storageExcel.appendRow(new Person());
        }
        storageExcel.saveToFile();
        System.out.println("Файл создан. Путь: " + new File(filename).getCanonicalPath());
    }
}
