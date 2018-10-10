import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import java.util.Date;

public class Person {
    public ColumnFirstName firstName;
    public ColumnSecondName secondName;
    public ColumnPatronymicName patronymicName;
    public ColumnGender gender;
    public ColumnBirthDate birthDate;
    public ColumnRuTIN ruTIN;
    public ColumnZIP zip;
    public ColumnCountry country;
    public ColumnRegion region;
    public ColumnCity city;
    public ColumnStreet street;
    public ColumnHouse house;
    public ColumnFlat flat;

    private Date now;

    Person() {
        Gender gender = Rand.randomGender();
        firstName = new ColumnFirstName(gender);
        secondName = new ColumnSecondName(gender);
        patronymicName = new ColumnPatronymicName(gender);
        this.gender = new ColumnGender(gender);
        birthDate = new ColumnBirthDate();
        ruTIN = new ColumnRuTIN();
        zip = new ColumnZIP();
        country = new ColumnCountry();
        region = new ColumnRegion();
        city = new ColumnCity();
        street = new ColumnStreet();
        house = new ColumnHouse();
        flat = new ColumnFlat();
        now = new Date();
    }

    int getAge() {
        int year = now.getYear() - 70;
        return year + (int) (birthDate.getDate().getTime() / (1471228928));
    }

    void fillLine(Row row, CellStyle dateStyle) {
        row.createCell(1).setCellValue(firstName.toString());
        row.createCell(2).setCellValue(secondName.toString());
        row.createCell(3).setCellValue(patronymicName.toString());
        row.createCell(4).setCellValue(this.getAge());
        row.createCell(5).setCellValue(this.gender.toString());
        row.createCell(6).setCellValue(birthDate.getDate());
        row.getCell(6).setCellStyle(dateStyle);
        row.createCell(7).setCellValue(ruTIN.toString());
        row.createCell(8).setCellValue(zip.toString());
        row.createCell(9).setCellValue(country.toString());
        row.createCell(10).setCellValue(region.toString());
        row.createCell(11).setCellValue(city.toString());
        row.createCell(12).setCellValue(street.toString());
        row.createCell(13).setCellValue(house.getValue());
        row.createCell(14).setCellValue(flat.getValue());
    }
}
