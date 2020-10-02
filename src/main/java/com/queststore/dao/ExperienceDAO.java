package com.queststore.dao;

import com.queststore.model.Experience;

import java.util.List;

public interface ExperienceDAO {

    List<Experience> getExperience();

    void create(Experience experience);

    void update(Experience experience);

    void delete(int id);

    int getLevel(long experience);
}
