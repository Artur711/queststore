package com.queststore.service;

import com.queststore.model.Experience;
import com.queststore.repository.ExperienceRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExperienceServiceTest {


    @Mock
    private ExperienceRepository experienceRepository;

    @InjectMocks
    private ExperienceService experienceService;

    @Test
    public void should_return_level() {
        //given:
        Long experience = 250L;
        int expectedResult = 3;
        List<Experience> experienceList = new ArrayList<>();
        experienceList.add(new Experience(1,100));
        experienceList.add(new Experience(2,200));
        experienceList.add(new Experience(3,300));

        //when:
        when(experienceRepository.sortExperience()).thenReturn(experienceList);

        int result = experienceService.getLevel(experience);

        //then:
        assertEquals(result, expectedResult);
    }
}