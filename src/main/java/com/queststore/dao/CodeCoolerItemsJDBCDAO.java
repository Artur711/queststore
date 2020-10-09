package com.queststore.dao;

import com.queststore.model.CodeCoolerItems;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public class CodeCoolerItemsJDBCDAO {
//    private final SpringJdbcConfig datasource;
//    private final JdbcTemplate temp;
//    private String query;
//
//    public CodeCoolerItemsJDBCDAO(SpringJdbcConfig datasource) {
//        this.datasource = datasource;
//        this.temp = new JdbcTemplate(datasource.postgresDataSource());
//    }
//
//    @Override
//    public List<CodeCoolerItems> getAll() {
//        query = "select codecooler_item.*, items.name  from items inner join codecooler_item on codecooler_item.item_id = items.item_id;";
//        return temp.query(query, new CodeCoolerItemsMapper());
//    }
//
//    @Override
//    public List<CodeCoolerItems> getByCodeCoolerID(long id) {
//        String temQuery = "select codecooler_item.*, items.name  from items inner join codecooler_item on codecooler_item.item_id = items.item_id";
//        query = String.format("%s and codecooler_id = %d;", temQuery, id);
//        return temp.query(query, new CodeCoolerItemsMapper());
//    }
//
//    @Override
//    public void markUsedItem(long id) {
//        query = String.format("UPDATE codecooler_item SET used = 0 WHERE codecooler_item_id = %d", id);
//        temp.batchUpdate(query);
//    }
}
