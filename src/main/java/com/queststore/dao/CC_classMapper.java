package com.queststore.dao;

import com.queststore.model.CC_Class;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CC_classMapper implements RowMapper<CC_Class> {
    @Override
    public CC_Class mapRow(ResultSet resultSet, int i) throws SQLException {
        int classId = resultSet.getInt("class_id");
        String className = resultSet.getString("name");
        return new CC_Class(classId, className);
    }
}
