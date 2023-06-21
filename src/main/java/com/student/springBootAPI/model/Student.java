package com.student.springBootAPI.model;

import javax.persistence.*;

@Entity
@Table(name = "studentDetails")
public class Student {
    @Id
    @Column(name = "roll_no")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "section")
    private int section;

    public Student() {
    }
    public Student(String firstName, String lastName, int section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
    }

    public Student(Long id, String firstName, String lastName, int section) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.section = section;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", section=" + section +
                '}';
    }
}
