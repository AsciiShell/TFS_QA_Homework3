import java.io.File;
import java.io.IOException;
import java.util.Date;

public class DataSetGenerator {
    public static void main(String[] args) throws IOException {
        String filename = "test.xlsx";
        DataStorageExcel storageExcel = new DataStorageExcel();
        int items = Rand.randomInt(1, 30);
        for (int i = 0; i < items; i++) {
            storageExcel.appendRow(new Person("Иван", "Иванов", "Иванович", Gender.MALE, new Date(10*i, 1, 1), "465",
                    new Address("asd", "asd", 12700, "asd", "vdfg", "asd",15)));
        }
        storageExcel.saveToFile(filename);
        System.out.println("Файл создан. Путь: " + new File(filename).getCanonicalPath());
    }
}
