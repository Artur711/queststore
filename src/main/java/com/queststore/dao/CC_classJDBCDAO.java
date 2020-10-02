package com.queststore.dao;

import com.queststore.model.CC_Class;
import com.queststore.model.Codecoolers;
import com.queststore.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CC_classJDBCDAO implements CC_classDAO {
    private MentorJDBCDAO mentorDAO;
    private CodeCoolerJDBCDAO codecoolerDAO;
    private SpringJdbcConfig datasource;
    private JdbcTemplate temp;
    private String query;
    private final String tranBegQuery = "BEGIN TRANSACTION; ";
    private final String tranEndQuery = " COMMIT;";

    public CC_classJDBCDAO(SpringJdbcConfig datasource, MentorJDBCDAO mentorDAo, CodeCoolerJDBCDAO codecoolerDAO) {
        this.codecoolerDAO = codecoolerDAO;
        this.mentorDAO = mentorDAo;
        this.datasource = datasource;
        this.temp = new JdbcTemplate((datasource.postgresDataSource()));
    }


    @Override
    public void create(CC_Class cc_class) {
        query = String.format("Insert into classrooms (name) values ('%s') RETURNING class_id; ", cc_class.getName());

        Integer class_id = temp.query(query, rs -> {
            if (rs.next()) {
                return rs.getInt("class_id");
            }
            return null;
        });
        query = tranBegQuery;
        List<User> userList = cc_class.getMentors();
        if (userList != null) {
            for (User mentor : userList
            ) {
                query = query + " " + String.format("INSERT into users_classrooms (user_id, class_id) VALUES (%d, %d);", mentor.getUserId(), class_id);
            }
        }
//        List<Codecoolers> ccList = cc_class.getStudents();
//        for (Codecoolers cc : ccList
//        ) {
//            query = query + " " + String.format("INSERT into users_classrooms (user_id, class_id) VALUES (%d, %d);", cc.getUserId(), class_id);
//        }
        query = query + tranEndQuery;
        System.out.println(query);
        temp.execute(query);
    }

    @Override
    public void delete(Integer id) {
        query = String.format("Delete from Classrooms where class_id  = %d", id);
        temp.execute(query);

    }

    @Override
    public void update(CC_Class cc_class) {

    }

    @Override
    public List<CC_Class> getAll() {
        return null;
    }
}
