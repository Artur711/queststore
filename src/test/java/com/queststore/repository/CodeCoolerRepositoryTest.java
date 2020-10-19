package com.queststore.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CodeCoolerRepositoryTest {
    @Autowired
    private CodeCoolerRepository codeCoolerRepository;

    @Test
    public void should_update_CoinsBalance() {
        //given:
        int coins = 100;
        Long id = 1L;

        //when:
        codeCoolerRepository.updateCoinsBalance(coins, id);

        //then:
        assertEquals(codeCoolerRepository.findById(id).get().getCodeCoolCoins(),coins);
    }
}