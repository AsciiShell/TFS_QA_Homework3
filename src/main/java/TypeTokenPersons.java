import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TypeTokenPersons {
    public static List<Person> toList(String json) {
        Type type = new TypeToken<List<Person>>() {
        }.getType();
        return new Gson().fromJson(json, type);
    }

    public static Person[] toArray(String json) {
        return new Gson().fromJson(json, Person[].class);
    }

    public static String fromArray(Person[] person) {
        return new Gson().toJson(person);
    }

    public static String fromList(List<Person> person) {
        return new Gson().toJson(person);
    }
}
