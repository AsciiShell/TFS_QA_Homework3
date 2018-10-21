import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import io.github.openunirest.http.HttpResponse;
import io.github.openunirest.http.Unirest;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataStorageAPI extends ADataStorage implements IDataGet {
    @Override
    public ArrayList<Person> getList() {
        return getList(30);
    }

    @Override
    public ArrayList<Person> getList(int count) {
        Type type = new TypeToken<ArrayList<Person>>() {
        }.getType();
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(type, new PersonDeserialize())
                .create();
        HttpResponse<String> response =
                Unirest.get("https://randomapi.com/api/c87l3m9f")
                        .queryString("key", "OSKM-NK2B-13FR-NW03")
                        .queryString("count", count)
                        .asString();
        if (response.getStatus() == 200) {
            String str = response.getBody();
            persons = gson.fromJson(str, type);
            return persons;
        } else {
            System.out.println("No Internet");
            return null;
        }

    }
}
