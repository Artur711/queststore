package com.queststore.dao;

import com.queststore.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class ItemJDBCDAO{
//    private SpringJdbcConfig datasource;
//    private JdbcTemplate jdbcTemplate;
//    private String query;
//
//    public ItemJDBCDAO(SpringJdbcConfig datasource){
//        this.datasource = datasource;
//        this.jdbcTemplate = new JdbcTemplate(datasource.postgresDataSource());
//    }
//
//    @Override
//    public List<Item> getAll() {
//        return jdbcTemplate.query("SELECT * FROM Items", new ItemMapper());
//    }
//
//    @Override
//    public Item getByID(Long id) {
//        List<Item> itemList = getAll();
//
//        for(Item item : itemList) {
//            if(item.getItemId() == id){
//                return item;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(Long id) {
//        query = String.format("DELETE from Item WHERE item_id = %d", id);
//        jdbcTemplate.batchUpdate(query);
//    }
//
//    @Override
//    public void create(Item item) {
//
//        long itemId = item.getItemId();
//        String name = item.getName();
//        String description = item.getDescription();
//        int price = item.getPrice();
//        int itemTypeId = item.getItemTypeId();
//
//        String queryInsert = "INSERT INTO Item (item_id, name, description, price, item_type_id) VALUES";
//        query = String.format("%s (%d, %s, %s, %d, %d);", queryInsert, itemId, name, description, price, itemTypeId);
//        jdbcTemplate.batchUpdate(query);
//    }
//
//    @Override
//    public void update(Item item) {
//        long itemId = item.getItemId();
//        String name = item.getName();
//        String description = item.getDescription();
//        int price = item.getPrice();
//        int itemTypeId = item.getItemTypeId();
//
//        String querySet = String.format("SET item_id = %d, name = %s, description = %s, price = %d, item_type_id = %d", itemId, name, description, price, itemTypeId);
//        query = String.format("UPDATE Item %s WHERE item_id = %d", querySet, itemId);
//        jdbcTemplate.batchUpdate(query);
//    }
}
