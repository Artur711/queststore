package com.queststore.dao;

import com.queststore.model.CodecoolerMapper;
import com.queststore.model.Codecoolers;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        return temp.query("select users.first_name, users.last_name, users.email, users.password, users.phone, users.user_type,  codecoolers.* from users INNER JOIN codecoolers ON users.user_id = codecoolers.user_id;", new CodecoolerMapper());
    }

    @Override
    public void create(Codecoolers codecoolers) {
        String queryInsert = "INSERT INTO users (first_name, last_name, email, password, phone, user_type) VALUES";
        String firstName = codecoolers.getFirstName();
        String lastName = codecoolers.getLastName();
        String email = codecoolers.getEmail();
        String password = codecoolers.getPassword();
        int phoneNumber = codecoolers.getPhoneNumber();

        query = String.format("%s ('%s', '%s', '%s', '%s', %d, 1) RETURNING user_id;", queryInsert, firstName, lastName, email, password, phoneNumber);
        Integer id = temp.query(query, rs -> {
            if (rs.next()) {
                Integer lastAddedId = rs.getInt("user_id");
                return lastAddedId;
            }
            return null;
        });
        System.out.println(id);

        queryInsert = "INSERT INTO codecoolers (user_id, loe_id, codecool_coins) VALUES";
        int userID = id;
        int codeCoolerLevel = codecoolers.getLoe_id();
        int codeCoolerCoins = codecoolers.getCodecool_coins();

        query = String.format("%s (%d, %d, %d);", queryInsert, userID, codeCoolerLevel, codeCoolerCoins);
        temp.batchUpdate(query);

    }

    private int getUser(Codecoolers codecoolers) {
        String firstName = codecoolers.getFirstName();
        String lastName = codecoolers.getLastName();
        String email = codecoolers.getEmail();
        String password = codecoolers.getPassword();
        int phoneNumber = codecoolers.getPhoneNumber();

        String queryWhere = String.format("first_name = '%s' AND last_name = '%s' AND email = 's' AND password = 's' AND phone = %d", firstName, lastName, email, password, phoneNumber);
        query = String.format("SELECT users WHERE %s", queryWhere);

        Codecoolers codecoolers1 = temp.query(query, new CodecoolerMapper()).get(0);
        return 1;
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
