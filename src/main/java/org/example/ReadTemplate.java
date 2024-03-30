package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Sheet;
import org.example.model.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReadTemplate {
    private String file;

    public ReadTemplate(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<Person> readTemplate() throws IOException, NumberFormatException {
        List<Person> listStudent = new ArrayList<Person>();
        try (FileInputStream file = new FileInputStream(getFile());
//        XSSFWorkbook wb = new XSSFWorkbook(file);
//        XSSFSheet sheet = wb.getSheetAt(0);
             ReadableWorkbook wb = new ReadableWorkbook(file)) {
            Sheet sheet = wb.getFirstSheet();
            for (org.dhatim.fastexcel.reader.Row row : sheet.read()) {
                if (!row.getCellText(0).isEmpty()) {
                    Person student = new Person();
                    student.setSid(row.getCellText(1));
                    student.setName(row.getCellText(2));

                    listStudent.add(student);
                }
            }
        }
//        System.out.println(listStudent);

        return listStudent;
    }
}
