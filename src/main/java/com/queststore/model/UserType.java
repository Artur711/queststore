package com.queststore.model;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_type")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_type_id")
    @Setter(AccessLevel.PROTECTED)
    private Long userTypeID;

    @Column(name = "user_type_name")
    private String userTypeName;

    public UserType(Long userTypeID, String userTypeName) {
        this.userTypeID = userTypeID;
        this.userTypeName = userTypeName;
    }
}
