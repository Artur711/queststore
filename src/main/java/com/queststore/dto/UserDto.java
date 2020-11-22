package com.queststore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String photoUrl;
    private long phoneNumber;
    private int userType;


}
