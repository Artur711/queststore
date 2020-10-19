package com.queststore.service;

import com.queststore.model.CodeCooler;
import com.queststore.repository.CodeCoolerRepository;
import com.queststore.repository.QuestRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class CodeCoolerServiceTest {

    @Mock
    private CodeCoolerRepository repository;

    @Mock
    private CodeCoolerItemsService codeCoolerItemsService;

    @Mock
    private ItemService itemService;

    @Mock
    private QuestRepository questRepository;


    @InjectMocks
    private CodeCoolerService codeCoolerService;

    @Test
    public void should_get_code_cooler_by_id() {
        //given
        List<CodeCooler> userList = getUserList();
        Long id1 = 305L;
        Long id2 = 802L;
        Long id3 = 103L;

        //when
        when(repository.findAll()).thenReturn(userList);

        //then
        assertAll((Executable) () -> assertEquals(codeCoolerService.getCodeCoolerById(id1).getUserId(), id1),
                  (Executable) () -> assertEquals(codeCoolerService.getCodeCoolerById(id1).getFirstName(), "Kris"),
                  (Executable) () -> assertEquals(codeCoolerService.getCodeCoolerById(id2).getUserId(), id2),
                  (Executable) () -> assertEquals(codeCoolerService.getCodeCoolerById(id2).getFirstName(), "Pablo"),
                  (Executable) () -> assertEquals(codeCoolerService.getCodeCoolerById(id3).getUserId(), id3),
                  (Executable) () -> assertEquals(codeCoolerService.getCodeCoolerById(id3).getFirstName(), "Nicole"));
    }

    private List<CodeCooler> getUserList() {
        CodeCooler codeCooler1 = new CodeCooler();
        CodeCooler codeCooler2 = new CodeCooler();
        CodeCooler codeCooler3 = new CodeCooler();

        codeCooler1.setUserId(305);
        codeCooler1.setFirstName("Kris");

        codeCooler2.setUserId(802);
        codeCooler2.setFirstName("Pablo");

        codeCooler3.setUserId(103);
        codeCooler3.setFirstName("Nicole");

        return Arrays.asList(codeCooler1, codeCooler2, codeCooler3);
    }
}