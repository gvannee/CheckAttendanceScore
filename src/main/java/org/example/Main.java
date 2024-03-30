package org.example;

import org.example.model.Attendance;
import org.example.model.Person;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileLocation = "Attendance.xlsx";
        System.out.print("Input your grade file: ");
        String attendanceGrade = sc.next();
        System.out.print("Input your week number: ");
        String fileName = sc.next();
//        String fileLocation = "Attendance.xlsx";
        ReadCsv csv = new ReadCsv(attendanceGrade);
        ReadTemplate xlsx = new ReadTemplate(fileLocation);
        Result result = new Result(fileName);
//        List<Attendance> attendanceList = csv.getListAttendance();
        List<Person> listStudent = xlsx.readTemplate();
        listStudent = csv.checkAttendance(listStudent);

        result.createExcel(listStudent);
    }
}