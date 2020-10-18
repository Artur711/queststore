package com.queststore.service;

import com.queststore.model.Experience;
import com.queststore.repository.ExperienceRepository;
import org.assertj.core.util.Arrays;
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
public class ExperienceServiceTest2 {


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


        when(experienceRepository.sortExperience()).thenReturn(experienceList);


        //when:

        int result = experienceService.getLevel(experience);

        assertEquals(result, expectedResult);
//        when(userRepository.findAll()).thenReturn(createUsersSamples());



    }
}