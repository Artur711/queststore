package com.queststore.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        int userId = rs.getInt("user_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        String password = rs.getString("password");
        int phoneNumber = rs.getInt("phone");
        int userType = rs.getInt("user_type");

        return new User(userId, firstName, lastName, email, password, phoneNumber, userType);
    }
}

