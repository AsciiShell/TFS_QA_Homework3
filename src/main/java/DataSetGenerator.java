public class DataSetGenerator {
    public static void main(String[] args) {
        int count = Rand.randomInt(1, 30);
        DataStorageExcel storage = new DataStorageExcel();
        storage.extend(new DataStorageAPI().getList(count));
        storage.save("test.xlsx");
        System.out.println("Все сохранено");
    }
}
