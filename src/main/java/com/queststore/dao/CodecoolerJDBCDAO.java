package com.queststore.dao;

import com.queststore.model.CodecoolerMapper;
import com.queststore.model.Codecoolers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class CodecoolerJDBCDAO implements CodecoolerDAO {
    private SpringJdbcConfig datasource;
    private SimpleJdbcInsert simpleJdbcInsert;
    private JdbcTemplate temp;

    public CodecoolerJDBCDAO(SpringJdbcConfig datasource) {
        this.datasource = datasource;
        this.simpleJdbcInsert = new SimpleJdbcInsert(datasource.postgresDataSource()).withTableName("Codecoolers");
        this.temp = new JdbcTemplate(datasource.postgresDataSource());
    }

    @Override
    public List<Codecoolers> getAll() {
        List<Codecoolers> cdlist = temp.query("Select * from Codecoolers", new CodecoolerMapper());
        return  cdlist;
    }

//    public int addCodecooler(Codecoolers codecooler) {
//        Map<String, Object> parameters = new HashMap<String, Object>();
//        parameters.put("codecooler_id", codecooler.getCodecooler_id());
//        parameters.put("user_id", codecooler.getUser_id());
//        parameters.put("loe_id", codecooler.getLoe_id());
//        parameters.put("codecool_coins", codecooler.getCodecool_coins());
//
//        return simpleJdbcInsert.execute(parameters);
//    }

    @Override
    public void create(Codecoolers codecoolers) {
        String queryInsert = "INSERT INTO Codecoolers (user_id, loe_id, codecool_coins) VALUES";
        int userID = codecoolers.getUser_id();
        int codeCoolerLevel = codecoolers.getLoe_id();
        int codeCoolerCoins = codecoolers.getCodecool_coins();

        String query = String.format("%s (%d, %d, %d);", queryInsert, userID, codeCoolerLevel, codeCoolerCoins);
        temp.batchUpdate(query);
    }

    @Override
    public void update(Codecoolers codecoolers) {
    }

    @Override
    public void delete(Long id) {

    }
}
