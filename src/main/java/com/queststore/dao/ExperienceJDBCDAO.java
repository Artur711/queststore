package com.queststore.dao;

import com.queststore.model.Experience;
import com.queststore.model.ExperienceMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExperienceJDBCDAO implements ExperienceDAO {
    private final SpringJdbcConfig datasource;
    private final JdbcTemplate temp;
    private String query;

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
        query = String.format("INSERT INTO loe (max_value) VALUES (%d);", experience.getValue());
        temp.batchUpdate(query);
    }

 /*   @Override
    public void update(Experience experience) {
        query = String.format("UPDATE loe SET max_value = %d WHERE loe_id = %d;", experience.getValue(), experience.getLoeID());
        temp.batchUpdate(query);
    }*/

    @Override
    public void delete(int id) {
        long loeID = getExperience().get(id).getLoeID();
        query = String.format("DELETE FROM loe WHERE loe_id = %d;", loeID);
        temp.batchUpdate(query);
    }

    @Override
    public int getLevel(long experience) {
        return 0;
    }
}
