package com.queststore.service;


import com.queststore.model.Item;
import com.queststore.model.Quest;
import com.queststore.repository.QuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    
    public void save(Quest quest) {repository.save(quest);}

    public List<Quest> getAll() {
        return repository.findAll();
    }

    public Quest getById(Long id) {
        List<Quest> questList = repository.findAll();
        return questList.stream().filter(quest -> quest.getQuestId() == id).findAny().orElse(null);
    }

    public void completeQuest(Long userId, Long questId) {
        repository.insertQuestIntoAccomplishedTable(questId, userId);
    }

    public List<Quest> getCodecoolerQuests(Long codecoolerId){
        List<Long> questsIds = repository.getUserQuests(codecoolerId);
        List<Quest> guestsList = new ArrayList<>();
        for (Long questId: questsIds){
            guestsList.add(repository.findById(questId).get());
        }
        return  guestsList;
    }

    public List<Quest> getListOfQuests(List<Long> questsId) {
        List<Quest> resultList = new ArrayList<>();
        for (Long questId: questsId) {
            resultList.add(repository.findById(questId).get());
        }

        return resultList;
    }

    public List<Quest> getUniqueQuests(Long codecoolerId) {

        List<Long> allQuestsId = new ArrayList<>(repository.getAllQuestsId(codecoolerId));
        allQuestsId.removeAll(new ArrayList<>(repository.getUserQuests(codecoolerId)));

        return getListOfQuests(allQuestsId);
    }

}
