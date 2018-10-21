
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class DataStorageDB extends ADataStorage implements IDataGet, AutoCloseable {
    private Connection con;

    DataStorageDB() {
        String fullName = DataStorageDB.class.getResource("db.properties").getFile().substring(1);
        Properties props = new Properties();
        FileInputStream in;
        try {
            in = new FileInputStream(fullName);
            props.load(in);
            in.close();

            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            con = DriverManager.getConnection(url, username, password);

        } catch (IOException e) {
            System.out.println("Не удалось получить данные для подключения");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к БД");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Person> getList() {
        return getList(30);
    }

    @Override
    public ArrayList<Person> getList(int count) {
        persons.clear();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `users` ORDER BY RAND() LIMIT " + Integer.toString(count));
            while (rs.next()) {
                persons.add(new Person(rs.getString("firstName"),
                        rs.getString("secondName"),
                        rs.getString("patronymicName"),
                        Gender.fromString(rs.getString("gender")),
                        rs.getDate("birthDate"),
                        rs.getString("ruTIN"),
                        new Address(rs.getString("country"),
                                rs.getString("region"),
                                rs.getInt("zip"),
                                rs.getString("city"),
                                rs.getString("street"),
                                rs.getString("house"),
                                rs.getInt("flat"))));
            }
            return persons;
        } catch (SQLException e) {
            e.printStackTrace();
            persons.clear();
            return null;
        }
    }

    public boolean save() {
        String queryInsert = "INSERT INTO `users`(`firstName`, `secondName`, `patronymicName`, `gender`, `birthDate`, `ruTIN`, `country`, `region`, `zip`, `city`, `street`, `house`, `flat`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String queryUpdate = "UPDATE `users` SET `gender` = ?, " +
                "`birthDate` = ?, " +
                "`ruTIN` = ?, " +
                "`country` = ?, " +
                "`region` = ?, " +
                "`zip` = ?, " +
                "`city` = ?, " +
                "`street` = ?, " +
                "`house` = ?, " +
                "`flat` = ? WHERE `id` = ?";
        String querySelect = "SELECT `id` FROM `users` WHERE `firstName` = ? AND `secondName` = ? AND `patronymicName` = ? LIMIT 1";
        try {
            PreparedStatement preparedStmtInsert = con.prepareStatement(queryInsert);
            PreparedStatement preparedStmtUpdate = con.prepareStatement(queryUpdate);
            PreparedStatement preparedStmtSelect = con.prepareStatement(querySelect);
            for (Person person : persons) {
                preparedStmtSelect.setString(1, person.getFirstName());
                preparedStmtSelect.setString(2, person.getSecondName());
                preparedStmtSelect.setString(3, person.getPatronymicName());
                ResultSet rs = preparedStmtSelect.executeQuery();
                if (!rs.next()) {
                    preparedStmtInsert.setString(1, person.getFirstName());
                    preparedStmtInsert.setString(2, person.getSecondName());
                    preparedStmtInsert.setString(3, person.getPatronymicName());
                    preparedStmtInsert.setString(4, person.getGender().toSQL());
                    preparedStmtInsert.setDate(5, new java.sql.Date(person.getBirthDate().getTime()));
                    preparedStmtInsert.setString(6, person.getRuTIN());
                    preparedStmtInsert.setString(7, person.getAddress().getCountry());
                    preparedStmtInsert.setString(8, person.getAddress().getRegion());
                    preparedStmtInsert.setInt(9, person.getAddress().getZip());
                    preparedStmtInsert.setString(10, person.getAddress().getCity());
                    preparedStmtInsert.setString(11, person.getAddress().getStreet());
                    preparedStmtInsert.setString(12, person.getAddress().getHouse());
                    preparedStmtInsert.setInt(13, person.getAddress().getFlat());
                    preparedStmtInsert.execute();
                } else {
                    int id = rs.getInt("id");
                    preparedStmtUpdate.setString(1, person.getGender().toSQL());
                    preparedStmtUpdate.setDate(2, new java.sql.Date(person.getBirthDate().getTime()));
                    preparedStmtUpdate.setString(3, person.getRuTIN());
                    preparedStmtUpdate.setString(4, person.getAddress().getCountry());
                    preparedStmtUpdate.setString(5, person.getAddress().getRegion());
                    preparedStmtUpdate.setInt(6, person.getAddress().getZip());
                    preparedStmtUpdate.setString(7, person.getAddress().getCity());
                    preparedStmtUpdate.setString(8, person.getAddress().getStreet());
                    preparedStmtUpdate.setString(9, person.getAddress().getHouse());
                    preparedStmtUpdate.setInt(10, person.getAddress().getFlat());
                    preparedStmtUpdate.setInt(11, id);
                    preparedStmtUpdate.execute();
                }


            }
            persons.clear();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void close() throws Exception {
        con.close();
    }
}
