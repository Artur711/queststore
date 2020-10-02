package com.queststore.service;

import com.queststore.dao.ExperienceDAO;
import com.queststore.model.Experience;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    private final ExperienceDAO dao;

    public ExperienceService(ExperienceDAO dao) {
        this.dao = dao;
    }

    public List<Experience> getExperience() {
        return dao.getExperience();
    }

    public void create(Experience experience) {
        dao.create(experience);
    }

    public void update(Experience experience) {
        dao.update(experience);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public int getLevel(long experience) {
        return getLevel(experience);
    }
}
