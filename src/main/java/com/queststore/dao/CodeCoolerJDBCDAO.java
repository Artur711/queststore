package com.queststore.dao;

import com.queststore.model.CodecoolerMapper;
import com.queststore.model.Codecoolers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodeCoolerJDBCDAO implements CodecoolerDAO {
    private SpringJdbcConfig datasource;
    private JdbcTemplate temp;
    private String query;

    public CodeCoolerJDBCDAO(SpringJdbcConfig datasource) {
        this.datasource = datasource;
        this.temp = new JdbcTemplate(datasource.postgresDataSource());
    }

    @Override
    public List<Codecoolers> getAll() {
        return temp.query("Select * from Codecoolers", new CodecoolerMapper());
    }

    @Override
    public void create(Codecoolers codecoolers) {
        String queryInsert = "INSERT INTO Codecoolers (user_id, loe_id, codecool_coins) VALUES";
        int userID = codecoolers.getUser_id();
        int codeCoolerLevel = codecoolers.getLoe_id();
        int codeCoolerCoins = codecoolers.getCodecool_coins();

        query = String.format("%s (%d, %d, %d);", queryInsert, userID, codeCoolerLevel, codeCoolerCoins);
        temp.batchUpdate(query);
    }

    @Override
    public void update(Codecoolers codecoolers) {
        long codeCoolerID = codecoolers.getCodecooler_id();
        int userID = codecoolers.getUser_id();
        int codeCoolerLevel = codecoolers.getLoe_id();
        int codeCoolerCoins = codecoolers.getCodecool_coins();

        String querySet = String.format("SET user_id = %d, loe_id = %d, codecool_coins = %d", userID, codeCoolerLevel, codeCoolerCoins);
        query = String.format("UPDATE Codecoolers %s WHERE codecooler_id = %d;", querySet, codeCoolerID);
        temp.batchUpdate(query);
    }

    public void updateSingleField(int vaule){

    }

    @Override
    public void delete(Long id) {
        query = String.format("DELETE FROM Codecoolers WHERE codecooler_id = %d;", id);
        temp.batchUpdate(query);
    }

    @Override
    public Codecoolers getByID(Long id) {
        List<Codecoolers> cdList = getAll();

        for (Codecoolers codeCooler : cdList) {
            if (codeCooler.getCodecooler_id() == id) {
                return codeCooler;
            }
        }
        return null;
    }
}
