package org.example.model;

public class Attendance extends Person{
    private String grade;
    public Attendance(String name, String sid, String grade) {
        super(name, sid);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString() + ", grade= " + grade + "}" ;
    }
}
