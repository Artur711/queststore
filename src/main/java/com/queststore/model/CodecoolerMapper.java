package com.queststore.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CodecoolerMapper implements RowMapper<Codecoolers> {

    public Codecoolers mapRow(ResultSet rs, int rowNum) throws SQLException {

         int codecoolerId = rs.getInt("codecooler_id");
         int codecoolerUserId = rs.getInt("user_id");
         int codecoolerLoeId = rs.getInt("loe_id");
         int codecoolerCoinsId = rs.getInt("codecool_coins");


        return new Codecoolers(codecoolerId, codecoolerUserId, codecoolerLoeId, codecoolerCoinsId);
    }
}

