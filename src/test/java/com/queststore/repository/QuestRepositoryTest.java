package com.queststore.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class QuestRepositoryTest {

    @Autowired
    private QuestRepository questRepository;

    @Test
    void insertQuestIntoAccomplishedTable() {
        //given:
        Long questId = 24L;
        Long userId = 1L;

        //when:
        questRepository.insertQuestIntoAccomplishedTable(questId, userId);

        //then:
        assertEquals(questRepository.findById(questId).get().getQuestId(), questId);
    }
}