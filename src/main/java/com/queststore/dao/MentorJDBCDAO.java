package com.queststore.dao;

import com.queststore.model.Codecoolers;
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
        String queryInsert = "INSERT INTO users (first_name, last_name, email, password, phone, user_type) VALUES";
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String email = user.getEmail();
        String password = user.getPassword();
        int phoneNumber = user.getPhoneNumber();

        query = String.format("%s ('%s', '%s', '%s', '%s', %d, 2) RETURNING user_id;", queryInsert, firstName, lastName, email, password, phoneNumber);
        temp.batchUpdate(query);
    }

    @Override
    public void update(User mentor) {
        String querySet = String.format("SET first_name = '%s', last_name = '%s', email = '%s', password = '%s', phone = %d", mentor.getFirstName() , mentor.getLastName(),
                mentor.getEmail(), mentor.getPassword(), mentor.getPhoneNumber());
        query = String.format("UPDATE Users %s WHERE user_id = %d;", querySet, mentor.getUserId());
        temp.batchUpdate(query);
    }

    @Override
    public List<User> getAll() {
        return temp.query("Select * from Users where user_type = 2", new UserMapper());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User getMentorById(long id) {
        List<User> mentorsList = getAll();

        for (User mentor : mentorsList) {
            if (mentor.getUserId() == id) {
                return mentor;
            }
        }
        return null;
    }

}
