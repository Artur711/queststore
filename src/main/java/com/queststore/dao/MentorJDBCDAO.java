package com.queststore.dao;

import com.queststore.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MentorJDBCDAO implements UserDAO {

    private SpringJdbcConfig datasource;
    private JdbcTemplate temp;
    private String query;

    public MentorJDBCDAO(SpringJdbcConfig datasource) {
        this.datasource = datasource;
        this.temp = new JdbcTemplate(datasource.postgresDataSource());
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> getAll() {
    return temp.query("Select * from Users where user_type = 2", new UserMapper());
    }

    @Override
    public void delete(Long id) {

    }
}
