package com.queststore.dao;

import com.queststore.model.Quest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

public class QuestJDBCDAO {
    @Repository
    public class ItemJDBCDAO implements QuestDAO {
        private SpringJdbcConfig datasource;
        private JdbcTemplate jdbcTemplate;
        private String query;

        public ItemJDBCDAO(SpringJdbcConfig datasource) {
            this.datasource = datasource;
            this.jdbcTemplate = new JdbcTemplate(datasource.postgresDataSource());
        }

        @Override
        public List<Quest> getAll() {
            return null;
        }

        @Override
        public Quest getByID(int id) {
            return null;
        }

        @Override
        public void delete(int id) {

        }

        @Override
        public void create(Quest quest) {

        }

        @Override
        public void update(Quest quest) {

        }
    }
}
