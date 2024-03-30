package org.example;

import org.example.model.Attendance;
import org.example.model.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Double.parseDouble;

public class ReadCsv {
    private String fileName;
    private final static String COMMA_DELIMITER = ",";

    public ReadCsv(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<List<String>> readFile() {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
            return records;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Attendance updateStudent(List<String> list) {
        String replace = list.get(2) + "." + list.get(3);
        replace = replace.replaceAll("\"", "");
        return new Attendance(list.get(0), list.get(1), replace);
    }

    public List<Attendance> getListAttendance() {
        List<Attendance> attendanceList = new ArrayList<>();
        for (int i = 0; i < readFile().size(); i++) {
            attendanceList.add(updateStudent(readFile().get(i)));
        }
        return attendanceList;
    }

    public int isInClass(List<Attendance> listAttendance, String sid) {
        int left = 0;
        int right = listAttendance.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (Integer.parseInt(listAttendance.get(mid).getSid()) == Integer.parseInt(sid)) {
                return mid;
            }

            if (Integer.parseInt(listAttendance.get(mid).getSid()) < Integer.parseInt(sid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public List<Person> checkAttendance(List<Person> listStudent) {
        MergeSort ob = new MergeSort();
        List<Attendance> list = getListAttendance();
        List<Attendance> attendanceList = ob.sort(list, 0, list.size() - 1);
        for (int i = 0; i < listStudent.size(); i++) {
            String sid = listStudent.get(i).getSid();
            int attendanceIndex = isInClass(attendanceList, sid);
            if (attendanceIndex != -1) {
                listStudent.get(i).setGrade(attendanceList.get(attendanceIndex).getGrade());

            } else {
                listStudent.get(i).setGrade("0");
            }

        }

        return listStudent;
    }
}
