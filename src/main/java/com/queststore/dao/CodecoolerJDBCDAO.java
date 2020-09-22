package com.queststore.dao;

import com.queststore.model.Codecoolers;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class CodecoolerJDBCDAO implements CodecoolerDAO {
    SpringJdbcConfig datasource;
    SimpleJdbcInsert simpleJdbcInsert;
    public CodecoolerJDBCDAO(SpringJdbcConfig datasource) {
        this.datasource = datasource;
        this.simpleJdbcInsert = new SimpleJdbcInsert(datasource.postgresDataSource()).withTableName("Codecoolers");
    }

    public int addCodecooler(Codecoolers codecooler) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("codecooler_id", codecooler.getCodecooler_id());
        parameters.put("user_id", codecooler.getUser_id());
        parameters.put("loe_id", codecooler.getLoe_id());
        parameters.put("codecool_coins", codecooler.getCodecool_coins());

        return simpleJdbcInsert.execute(parameters);
    }
    @Override
    public void create(Codecoolers codecoolers) {
    }

    @Override
    public void update(Codecoolers codecoolers) {
    }

    @Override
    public List<Codecoolers> getAll() {
        JdbcTemplate temp = new JdbcTemplate(datasource.postgresDataSource());
        List<Codecoolers> cdlist = temp.query("Select * from Codecoolers", BeanPropertyRowMapper.newInstance(Codecoolers.class));
        return  cdlist;
    }

    @Override
    public void delete(Long id) {

    }
}
