import io.github.openunirest.http.exceptions.UnirestException;

import java.io.File;
import java.util.ArrayList;

public class DataSetGenerator {
    public static void main(String[] args) {
        int count = Rand.randomInt(1, 30);
        String filename = new File("test.xlsx").getAbsolutePath();

        DataStorageDB db = new DataStorageDB();
        try {
            db.extend(new DataStorageAPI().getList(count));
            db.save();
        } catch (UnirestException e) {
            System.out.println("Не удалось выполнить запрос к API");
        }

        ArrayList<Person> persons = db.getList(count);
        if (persons.size() == 0) {
            System.out.println("Нет данных для генерации");
        } else {
            DataStorageExcel excel = new DataStorageExcel();
            excel.extend(db.getList(count));
            if (excel.save(filename)) {
                System.out.println("Файл создан. Путь: " + filename);
            } else {
                System.out.println("Не удалось записать данные в файл");
            }
        }
    }
}
