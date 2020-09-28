package com.queststore.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {

    public Item mapRow(ResultSet rs, int i) throws SQLException {

        int itemId = rs.getInt("item_id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        int price = rs.getInt("price");
        String img = rs.getString("img");
        int itemTypeId = rs.getInt("item_type_id");

        return new Item(itemId, name, description, price, img, itemTypeId);
    }
}
