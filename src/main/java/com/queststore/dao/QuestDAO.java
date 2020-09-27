package com.queststore.dao;

import com.queststore.model.Quest;

import java.util.List;

public interface QuestDAO {
    List<Quest> getAll();

    Quest getByID(int id);

    void delete(int id);

    void create(Quest quest);

    void update(Quest quest);
}
