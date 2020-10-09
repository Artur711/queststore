package com.queststore.dao;

import com.queststore.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserLoginJDBCDAO  {
//    private final SpringJdbcConfig datasource;
//    private final JdbcTemplate temp;
//
//    public UserLoginJDBCDAO(SpringJdbcConfig datasource) {
//        this.datasource = datasource;
//        this.temp = new JdbcTemplate(datasource.postgresDataSource());
//    }
//
//    @Override
//    public User getUser(String login, String password) {
//        List<User> userList = temp.query("select * from users;", new UserMapper());
//
//        for (User user : userList) {
//            if (login.equals(user.getLastName())) {
//                if (password.equals(user.getPassword())) {
//                    return user;
//                }
//            }
//        }
//        return null;
//    }
}
