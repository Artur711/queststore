package com.queststore.repository;

import com.queststore.model.Experience;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExperienceRepository extends CrudRepository<Experience,Long> {

    List<Experience> findAll();

    @Query("SELECT e FROM Experience e order by e.value")
    List<Experience> sortExperience();

    Experience save(Experience experience);

    void delete(Experience experience);
}
