package com.queststore.repository;

import com.queststore.model.Quest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface QuestRepository extends CrudRepository<Quest, Long> {

    List<Quest> findAll();

    @Transactional
    @Modifying
    @Query(
            value =
                    "INSERT into quests_codecoolers (quest_id,codecooler_id) VALUES (:quest_id,:codecooler_id)",
            nativeQuery = true)
    void insertQuestIntoAccomplishedTable(@Param("quest_id") Long quest_id, @Param("codecooler_id") Long codecooler_id);

    @Transactional
    @Modifying
    @Query(
            value = "SELECT * FROM quests_codecoolers WHERE codecooler_id= :codecooler_id",
            nativeQuery = true)
    List<Long> getUserQuests(@Param("codecooler_id") Long codecooler_id);

    @Transactional
    @Modifying
    @Query(
            value = "SELECT quest_id FROM quests",
            nativeQuery = true)
    List<Long> getAllQuestsId(@Param("codecooler_id") Long codecooler_id);

}
