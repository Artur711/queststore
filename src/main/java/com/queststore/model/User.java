package com.queststore.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private @Id @Setter(AccessLevel.PROTECTED) long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;
    private String password;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "user_type")
    private int userType;

    public User(long userId, String firstName, String lastName, String email, String password, String photoUrl, int phoneNumber, int userType) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.photoUrl = photoUrl;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }
}
