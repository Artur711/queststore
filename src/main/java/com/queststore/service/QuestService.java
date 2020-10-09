package com.queststore.service;

import com.queststore.dao.QuestDAO;
import com.queststore.model.Quest;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
public class QuestService {

    private QuestDAO dao;

    public QuestService(QuestDAO dao) {
        this.dao = dao;
    }

    public void create(Quest quest) {
        dao.create(quest);
    }

    public void update(Quest quest) {
        dao.update(quest);
    }

    public void delete(Long id) { dao.delete(id); }

    public List<Quest> getAll(){
        return dao.getAll();
    }

    public Quest getById(Long id) {
        return dao.getByID(id);
    }
}
