import io.github.openunirest.http.exceptions.UnirestException;

import java.io.File;

public class DataSetGenerator {
    public static void main(String[] args) {
        int count = Rand.randomInt(1, 30);
        DataStorageExcel storage = new DataStorageExcel();
        String filename = new File("test.xlsx").getAbsolutePath();
        try {
            storage.extend(new DataStorageAPI().getList(count));
            if (storage.save(filename)) {
                System.out.println("Файл создан. Путь: " + filename);
            } else {
                System.out.println("Не удалось записать данные в файл");
            }
        } catch (UnirestException e) {
            System.out.println("Не удалось выполнить запрос к API");
        }
    }
}
