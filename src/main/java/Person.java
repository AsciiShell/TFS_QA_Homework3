import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class Person {
    private final String firstName;
    private final String secondName;
    private final String patronymicName;
    private final Gender gender;
    private final Date birthDate;
    private final String ruTIN;
    private final Address address;

    public Person(String firstName, String secondName, String patronymicName, Gender gender, Date birthDate, String ruTIN, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymicName = patronymicName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.ruTIN = ruTIN;
        this.address = address;
    }

    int getAge() {
        Locale local = new Locale("ru", "RU");
        Calendar a = Calendar.getInstance(local);
        a.setTime(this.birthDate);
        Calendar b = Calendar.getInstance(local);
        b.setTime(new Date());
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.DAY_OF_YEAR) > b.get(Calendar.DAY_OF_YEAR)) {
            diff--;
        }
        return diff;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public Gender getGender() {
        return gender;
    }

    public Date getBirthDate(){
        return birthDate;
    }

    public String getRuTIN() {
        return ruTIN;
    }

    public Address getAddress() {
        return address;
    }
}
