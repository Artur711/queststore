package com.queststore.dao;

import com.queststore.model.Quest;

import java.util.List;

public interface QuestDAO {

    List<Quest> getAll();

    Quest getByID(long id);

    void delete(long id);

    void create(Quest quest);

    void update(Quest quest);
}
