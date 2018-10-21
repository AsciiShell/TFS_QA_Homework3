import java.util.ArrayList;

public abstract class ADataStorage {
    protected ArrayList<Person> persons = new ArrayList<Person>();

    public void append(Person person) {
        persons.add(person);
    }

    public void extend(ArrayList<Person> personsList) {
        persons.addAll(personsList);
    }
}
