package com.queststore.service;

import com.queststore.model.Quest;
import com.queststore.repository.QuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestService {

    private final QuestRepository repository;

    public QuestService(QuestRepository repository) {
        this.repository = repository;
    }

    public void create(Quest quest) {
        repository.save(quest);
    }

    public void delete(Long id) {
        repository.delete(getById(id));
    }

    public List<Quest> getAll() {
        return repository.findAll();
    }

    public Quest getById(Long id) {
        List<Quest> questList = repository.findAll();
        return questList.stream().filter(quest -> quest.getQuestId() == id).findAny().orElse(null);
    }

    public void complateQuest(Long userId, Long questId) {
        repository.insertQuestIntoAccomplishedTable(questId, userId);
    }


}
