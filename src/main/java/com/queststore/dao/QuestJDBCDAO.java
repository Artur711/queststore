package com.queststore.dao;

import com.queststore.model.Quest;
import com.queststore.model.QuestMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class QuestJDBCDAO implements QuestDAO {
    private SpringJdbcConfig datasource;
    private JdbcTemplate jdbcTemplate;
    private String query;

    public QuestJDBCDAO(SpringJdbcConfig datasource) {
        this.datasource = datasource;
        this.jdbcTemplate = new JdbcTemplate(datasource.postgresDataSource());
    }

    @Override
    public List<Quest> getAll() {
        return jdbcTemplate.query("SELECT * FROM Quests", new QuestMapper());
    }

    @Override
    public Quest getByID(long id) {
        List<Quest> questList = getAll();

        for (Quest quest: questList) {
            if(quest.getQuestId() == id){
                return quest;
            }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        query = String.format("DELETE from Quest WHERE quest_id = %d", id);
        jdbcTemplate.batchUpdate(query);
    }

    @Override
    public void create(Quest quest) {
        long questId = quest.getQuestId();
        String name = quest.getName();
        String description = quest.getDescription();
        int questValue = quest.getQuestValue();
        String img = quest.getImg();
        int questTypeId = quest.getQuestTypeId();

        String queryInsert = "INSERT INTO Item (quest_id, name, description, quest_type_id, img, quest_value) VALUES";
        query = String.format("%s (%d, %s, %s, %d, %s, %d)", questId, name, description, questTypeId, img, questValue);
        jdbcTemplate.batchUpdate(query);
    }

    @Override
    public void update(Quest quest) {
        long questId = quest.getQuestId();
        String name = quest.getName();
        String description = quest.getDescription();
        int questValue = quest.getQuestValue();
        String img = quest.getImg();
        int questTypeId = quest.getQuestTypeId();

        String querySet = String.format("SET quest_id = %d, name = %s, description = %s, quest_type_id = %d, img = %s, quest_value = %d", questId, name, description, questTypeId, img, questValue);
        query = String.format("UPDATE Quest %s WHERE quest_id = %d", querySet, questId);
        jdbcTemplate.batchUpdate(query);
    }
}

