package com.queststore.model;

import org.springframework.data.relational.core.sql.In;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
@Entity
public class CC_Class {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer classId;

    private String name;
    private List<User> mentors;
    private List<Codecoolers> students;
//    private Date startingDate;


    public CC_Class() {
    }

    public CC_Class(String name) {
        this.name = name;
    }

    public CC_Class(String name, List<User> mentors) {
        this.name = name;
        this.mentors = mentors;
    }



    public CC_Class(Integer classId, String name, List<User> mentors, List<Codecoolers> students) {
        this.classId = classId;
        this.name = name;
        this.mentors = mentors;
        this.students = students;
    }

    public CC_Class(String name, List<User> mentors, List<Codecoolers> students) {
        this.name = name;
        this.mentors = mentors;
        this.students = students;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getMentors() {
        return mentors;
    }

    public void setMentors(List<User> mentors) {
        this.mentors = mentors;
    }

    public List<Codecoolers> getStudents() {
        return students;
    }

    public void setStudents(List<Codecoolers> students) {
        this.students = students;
    }
}
