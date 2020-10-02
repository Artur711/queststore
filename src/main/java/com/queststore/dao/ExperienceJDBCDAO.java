package com.queststore.dao;

import com.queststore.model.CodecoolerMapper;
import com.queststore.model.Experience;
import com.queststore.model.ExperienceMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExperienceJDBCDAO implements ExperienceDAO {
    private final SpringJdbcConfig datasource;
    private final JdbcTemplate temp;

    public ExperienceJDBCDAO(SpringJdbcConfig datasource) {
        this.datasource = datasource;
        this.temp = new JdbcTemplate(datasource.postgresDataSource());
    }

    @Override
    public List<Experience> getExperience() {
        return temp.query("SELECT * FROM loe ORDER BY max_value;", new ExperienceMapper());
    }

    @Override
    public void create(Experience experience) {

    }

    @Override
    public void update(Experience experience) {

    }

    @Override
    public void delete(Experience experience) {

    }

    @Override
    public int getLevel(long experience) {
        return 0;
    }
}
