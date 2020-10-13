package com.queststore.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private @Id long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;
    private String password;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "user_type")
    private int userType;

    @ManyToMany(mappedBy = "users")
    private List<CC_Class> cc_classes;

    public User(long userId, String firstName, String lastName, String email, String password, String photoUrl, long phoneNumber, int userType) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.photoUrl = photoUrl;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserId() == user.getUserId() &&
                getPhoneNumber() == user.getPhoneNumber() &&
                getUserType() == user.getUserType() &&
                Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getPhotoUrl(), user.getPhotoUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getFirstName(), getLastName(), getEmail(), getPassword(), getPhotoUrl(), getPhoneNumber(), getUserType());
    }
}
