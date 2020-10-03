package com.queststore.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CodeCoolerItemsMapper implements RowMapper<CodeCoolerItems> {

    public CodeCoolerItems mapRow(ResultSet rs, int rowNum) throws SQLException {

        long codeCoolerItemId = rs.getLong("codecooler_item_id");
        int ItemId = rs.getInt("item_id");
        long codeCoolerId = rs.getLong("codecooler_id");
        int used = rs.getInt("used");
        String name = rs.getString("name");

        return new CodeCoolerItems(codeCoolerItemId, ItemId, codeCoolerId, used, name);
    }
}
