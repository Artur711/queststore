package com.queststore.repository;

import com.queststore.model.Quest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface QuestRepository extends CrudRepository<Quest, Long> {

    Quest save(Quest quest);

    void delete(Quest quest);

    List<Quest> findAll();

    @Transactional
    @Modifying
    @Query(
            value =
                    "INSERT into QUESTS_CODECOOLERS (quest_id,codecooler_id) VALUES (:quest_id,:codecooler_id)",
            nativeQuery = true)
    void insertQuestIntoAccomplishedTable(@Param("quest_id") Long quest_id, @Param("codecooler_id") Long codecooler_id);
}
