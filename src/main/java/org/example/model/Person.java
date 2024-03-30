package org.example.model;

public class Person {
    private String name;
    private String sid;

    private String grade;


    public Person(String name, String sid) {
        this.name = name;
        this.sid = sid;
    }

    public Person() {

    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sid='" + sid + '\'' +
                ", grade= " + grade + "}";
    }
}
