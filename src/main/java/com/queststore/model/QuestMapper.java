package com.queststore.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestMapper implements RowMapper<Quest> {

    public Quest mapRow(ResultSet rs, int rowNum) throws SQLException {
        long questId = rs.getInt("quest_id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        int questTypeId = rs.getInt("quest_type_id");
        String img = rs.getString("img");
        int questValue = rs.getInt("quest_value");

        return new Quest(questId, name, description, questTypeId, img, questValue);
    }
}
