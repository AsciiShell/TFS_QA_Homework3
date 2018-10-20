import java.util.ArrayList;
import java.util.List;

public abstract class ADataStorage {
    protected List<Person> persons = new ArrayList<Person>();

    public void appendRow(Person person) {
        persons.add(person);
    }

    public abstract void saveToFile(String filename);
}
