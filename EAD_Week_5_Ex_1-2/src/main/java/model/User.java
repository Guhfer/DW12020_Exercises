package model;

import java.time.LocalDate;
import java.time.Period;

public class User {

    private String name;
    private LocalDate birthday;
    private Integer age;


    public User(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        this.age = calculateAge();
    }

    private Integer calculateAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
