package com.queststore.dao;

import com.queststore.model.CodecoolerMapper;
import com.queststore.model.Codecoolers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodeCoolerJDBCDAO implements CodeCoolerDAO {
    private final SpringJdbcConfig datasource;
    private final JdbcTemplate temp;
    private String query;
    private final String tranBegQuery = "BEGIN TRANSACTION; ";
    private final String tranEndQuery = " COMMIT;";

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
                return rs.getInt("user_id");
            }
            return null;
        });

        queryInsert = "INSERT INTO codecoolers (user_id, loe_id, codecool_coins) VALUES";
        int userID = id;
        int codeCoolerLevel = codecoolers.getLoe_id();
        int codeCoolerCoins = codecoolers.getCodecool_coins();

        query = String.format("%s (%d, %d, %d);", queryInsert, userID, codeCoolerLevel, codeCoolerCoins);
        temp.batchUpdate(query);
    }

    @Override
    public void update(Codecoolers codecoolers) {
        long codeCoolerID = codecoolers.getCodecooler_id();
        String firstName = codecoolers.getFirstName();
        String lastName = codecoolers.getLastName();
        String email = codecoolers.getEmail();
        String password = codecoolers.getPassword();
        int phoneNumber = codecoolers.getPhoneNumber();
        int userID = codecoolers.getUser_id();
        int codeCoolerLevel = codecoolers.getLoe_id();
        int codeCoolerCoins = codecoolers.getCodecool_coins();

        String querySet = String.format("SET loe_id = %d, codecool_coins = %d", codeCoolerLevel, codeCoolerCoins);
        query = tranBegQuery + String.format("UPDATE Codecoolers %s WHERE codecooler_id = %d;", querySet, codeCoolerID);

        querySet = String.format("SET first_name = '%s', last_name = '%s', email = '%s', password = '%s', phone = %d", firstName, lastName, email, password, phoneNumber);
        query = query + " " + String.format("UPDATE Users %s WHERE user_id = %d;", querySet, userID) + tranEndQuery;
        temp.execute(query);
    }

    @Override
    public void delete(Long id) {
        int user_id = getByID(id).getUser_id();
        query = tranBegQuery + String.format("DELETE FROM Codecoolers WHERE codecooler_id = %d;", id);
        query = query + " " + String.format("DELETE FROM Users WHERE user_id = %d;", user_id) + tranEndQuery;
        temp.execute(query);
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

    @Override
    public Codecoolers getByUserID(long id) {
        List<Codecoolers> codeCoolersList = getAll();

        for (Codecoolers codeCooler : codeCoolersList) {
            if (codeCooler.getUser_id() == id) {
                return codeCooler;
            }
        }
        return null;
    }

    @Override
    public void updateCoins(int userId, int coins, int itemId) {

        String querySet = tranBegQuery + String.format("UPDATE Codecoolers SET codecool_coins = %d WHERE codecooler_id = %d;",coins, userId);

        String queryInsert = "INSERT INTO codecooler_item (item_id, codecooler_id) VALUES";
        query = querySet + " " + String.format("%s (%d, %d);", queryInsert, itemId, userId) + tranEndQuery;

/*        query = query + tranEndQuery;*/

        temp.execute(query);

    }
}
