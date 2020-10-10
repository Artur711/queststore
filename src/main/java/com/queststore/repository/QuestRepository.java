package com.queststore.repository;

import com.queststore.model.Quest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestRepository extends CrudRepository<Quest, Long> {

    Quest save(Quest quest);

    void delete(Quest quest);

    List<Quest> findAll();
}
