import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class DataStorageExcel extends ADataStorage implements IDataSave {
    @Override
    public void save(String filename) {
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Люди");
        Row row = sheet.createRow(0);
        {
            row.createCell(0).setCellValue("№");
            row.createCell(1).setCellValue("Имя");
            row.createCell(2).setCellValue("Фамилия");
            row.createCell(3).setCellValue("Отчество");
            row.createCell(4).setCellValue("Возраст");
            row.createCell(5).setCellValue("Пол");
            row.createCell(6).setCellValue("Дата рождения");
            row.createCell(7).setCellValue("ИНН");
            row.createCell(8).setCellValue("Почтовый индекс");
            row.createCell(9).setCellValue("Страна");
            row.createCell(10).setCellValue("Область");
            row.createCell(11).setCellValue("Город");
            row.createCell(12).setCellValue("Улица");
            row.createCell(13).setCellValue("Дом");
            row.createCell(14).setCellValue("Квартира");
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
            row.createCell(1).setCellValue(item.getFirstName());
            row.createCell(2).setCellValue(item.getSecondName());
            row.createCell(3).setCellValue(item.getPatronymicName());
            row.createCell(4).setCellValue(item.getAge());
            row.createCell(5).setCellValue(item.getGender().toString());
            row.createCell(6).setCellValue(item.getBirthDate());
            row.getCell(6).setCellStyle(dateStyle);
            row.createCell(7).setCellValue(item.getRuTIN());
            row.createCell(8).setCellValue(item.getAddress().getZip());
            row.createCell(9).setCellValue(item.getAddress().getCountry());
            row.createCell(10).setCellValue(item.getAddress().getRegion());
            row.createCell(11).setCellValue(item.getAddress().getCity());
            row.createCell(12).setCellValue(item.getAddress().getStreet());
            row.createCell(13).setCellValue(item.getAddress().getHouse());
            row.createCell(14).setCellValue(item.getAddress().getFlat());
        }

        try {
            book.write(new FileOutputStream(filename));
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
