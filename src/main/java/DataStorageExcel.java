import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataStorageExcel implements IDataStorage {
    private List<Person> persons;
    private String filename;

    DataStorageExcel(String filename) {
        this.filename = filename;
        persons = new ArrayList<Person>();
    }

    public void appendRow(Person person) {
        persons.add(person);
    }

    public void saveToFile() {
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Люди");
        Row row = sheet.createRow(0);
        {
            Cell header = row.createCell(0);
            header.setCellValue("№");
            header = row.createCell(1);
            header.setCellValue("Имя");
            header = row.createCell(2);
            header.setCellValue("Фамилия");
            header = row.createCell(3);
            header.setCellValue("Отчество");
            header = row.createCell(4);
            header.setCellValue("Возраст");
            header = row.createCell(5);
            header.setCellValue("Пол");
            header = row.createCell(6);
            header.setCellValue("Дата рождения");
            header = row.createCell(7);
            header.setCellValue("ИНН");
            header = row.createCell(8);
            header.setCellValue("Почтовый индекс");
            header = row.createCell(9);
            header.setCellValue("Страна");
            header = row.createCell(10);
            header.setCellValue("Область");
            header = row.createCell(11);
            header.setCellValue("Город");
            header = row.createCell(12);
            header.setCellValue("Улица");
            header = row.createCell(13);
            header.setCellValue("Дом");
            header = row.createCell(14);
            header.setCellValue("Квартира");
        }
        DataFormat format = book.createDataFormat();
        CellStyle dateStyle = book.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd-mm-yyyy"));
        sheet.autoSizeColumn(1);
        int i = 1;
        for (Iterator<Person> p = persons.iterator(); p.hasNext(); i++) {
            Person item = p.next();
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(i);
            item.fillLine(row, dateStyle);
        }

        try {
            book.write(new FileOutputStream(filename));
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
