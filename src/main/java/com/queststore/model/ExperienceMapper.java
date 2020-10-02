package com.queststore.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExperienceMapper implements RowMapper<Experience> {

    public Experience mapRow(ResultSet rs, int rowNum) throws SQLException {

        long loeID = rs.getLong("loe_id");
        long value = rs.getLong("max_value");

        return new Experience(loeID, value);
    }
}
