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

    public void create(Experience experience) {
       repository.save(experience);
    }

    public Experience getExpById(long id){
        List<Experience> experienceList = repository.findAll();
        return experienceList.stream().filter(exp ->exp.getLoeID() == id).findAny().orElse(null);
    }

//    public void delete(int id) {
//        repository.delete(getExpById(id + 1));
//    }
//
//    public int getLevel(long experience) {
//        return dao.getLevel(experience);
//    }
}
