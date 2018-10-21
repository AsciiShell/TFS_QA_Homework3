import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PersonDeserialize implements JsonDeserializer<ArrayList<Person>> {
    @Override
    public ArrayList<Person> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonArray jPersons = json.getAsJsonObject().get("results").getAsJsonArray().get(0).getAsJsonObject().get("result").getAsJsonArray();
        ArrayList<Person> result = new ArrayList<>();
        for (int i = 0; i < jPersons.size(); i++) {
            JsonObject jPerson = jPersons.get(i).getAsJsonObject();
            JsonObject jAddress = jPerson.get("address").getAsJsonObject();
            try {
                result.add(new Person(jPerson.get("firstName").getAsString(),
                        jPerson.get("secondName").getAsString(),
                        jPerson.get("patronymicName").getAsString(),
                        Gender.fromInteger(jPerson.get("ggender").getAsInt()),
                        (new SimpleDateFormat("yyyy-MM-dd")).parse(jPerson.get("dab").getAsString()),
                        jPerson.get("TIN").getAsString(),
                        new Address(jAddress.get("country").getAsString(),
                                jAddress.get("state").getAsString(),
                                Integer.parseInt(jAddress.get("zip").getAsString()),
                                jAddress.get("city").getAsString(),
                                jAddress.get("street").getAsString(),
                                Integer.toString(jAddress.get("house").getAsInt()),
                                jAddress.get("flat").getAsInt())
                ));
            } catch (ParseException e) {
                throw new JsonParseException("Can't convert date string to date");
            }
        }
        return result;
    }
}
