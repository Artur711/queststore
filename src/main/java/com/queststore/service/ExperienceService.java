package com.queststore.service;

import com.queststore.model.Experience;
import com.queststore.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    private final ExperienceRepository repository;

    public ExperienceService(ExperienceRepository repository) {
        this.repository = repository;
    }

    public List<Experience> getExperience() {
        return repository.sortExperience();
    }

    public void save(Experience experience) {
       repository.save(experience);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public int getLevel(long experience) {
        List<Experience> experienceList = getExperience();
        int level = 1;

        for (Experience exp : experienceList) {
            if (experience >= exp.getValue()) {
                level++;
            }
        }
        return level;
    }
}
