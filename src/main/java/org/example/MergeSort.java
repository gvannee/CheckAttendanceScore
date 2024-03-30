package org.example;

import org.example.model.Attendance;

import java.util.List;

public class MergeSort {
    void merge(List<Attendance> attendanceList, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Attendance L[] = new Attendance[n1];
        Attendance R[] = new Attendance[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = attendanceList.get(l + i);
        }
        for (int j = 0; j < n2; j++) {
            R[j] = attendanceList.get(m + 1 + j);
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (Integer.parseInt(L[i].getSid()) <= Integer.parseInt(R[j].getSid())) {
                attendanceList.set(k, L[i]);
                i++;
            } else {
                attendanceList.set(k, R[j]);
                j++;
            }
            k++;
        }
        while (i < n1) {
            attendanceList.set(k, L[i]);
            i++;
            k++;
        }

        while (j < n2) {
            attendanceList.set(k, R[j]);
            j++;
            k++;
        }


    }
    public List<Attendance> sort(List<Attendance> listAttendance, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            //sort first and second halves
            sort(listAttendance, l, m);
            sort(listAttendance, m + 1, r);

            //Merge the sorted halves
            merge(listAttendance, l, m, r);
        }
        return listAttendance;
    }



    void printAttendance(List<Attendance> list) {
        int n = list.size();
        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i) + " ");
        }
        System.out.println();
    }
}
