package com.queststore.dao;

import com.queststore.model.User;
import com.queststore.model.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserLoginJDBCDAO {
    private SpringJdbcConfig datasource;
    private JdbcTemplate temp;

    public UserLoginJDBCDAO(SpringJdbcConfig datasource) {
        this.datasource = datasource;
        this.temp = new JdbcTemplate(datasource.postgresDataSource());
    }

    public User getUser(String login, String password) {
        List<User> userList = temp.query("select * from users;", new UserMapper());

        for (int i = 0; i < userList.size(); i++) {
            if (login.equals(userList.get(i).getLastName())) {
                if (password.equals(userList.get(i).getPassword())) {
                    return userList.get(i);
                }
            }

        }

        return null;
    }
}
