package com.queststore.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Classrooms")
public class CC_Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private long classId;

    private String name;

    @ManyToMany
    @JoinTable( joinColumns = @JoinColumn(name = "class_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    public CC_Class(String name) {
        this.name = name;
    }

    public CC_Class(long classId, String name) {
        this.classId = classId;
        this.name = name;
    }
}
