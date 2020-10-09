package com.queststore.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
//import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Classrooms")
public class CC_Class {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id @Setter(AccessLevel.PROTECTED) long classId;

    private String name;
//    private List<User> mentors;
//    private List<CodeCooler> students;
//    private Date startingDate;


    public CC_Class(long classId, String name) {
        this.classId = classId;
        this.name = name;
    }
}
