package domain;

import java.util.List;

public class Student {

    private String name;
    private List emails;
    private List courses;

    public Student(String name, List emails, List courses) {
        this.name = name;
        this.emails = emails;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getEmails() {
        return emails;
    }

    public void setEmails(List emails) {
        this.emails = emails;
    }

    public List getCourses() {
        return courses;
    }

    public void setCourses(List courses) {
        this.courses = courses;
    }
}
