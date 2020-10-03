package com.queststore.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

    public class CodecoolerMapper implements RowMapper<Codecoolers> {

    public Codecoolers mapRow(ResultSet rs, int rowNum) throws SQLException {

        int codeCoolerId = rs.getInt("codecooler_id");
        int codeCoolerUserId = rs.getInt("user_id");
        long codeCoolerLoeId = rs.getLong("exp");
        int codeCoolerCoinsId = rs.getInt("codecool_coins");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String email = rs.getString("email");
        String password = rs.getString("password");
        int phoneNumber = rs.getInt("phone");

        return new Codecoolers(codeCoolerId, codeCoolerUserId, codeCoolerLoeId, codeCoolerCoinsId, firstName, lastName, email, password, phoneNumber);
    }
}

