package com.queststore.repository;

import com.queststore.model.CC_Class;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CC_ClassRepository extends CrudRepository<CC_Class, Long> {

    List<CC_Class> findAll();

    CC_Class save(CC_Class cc_class);

    CC_Class getCC_ClassByName(String name);

    @Override
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(
            value =
                    "INSERT into CLASSROOMS_USERS (CC_CLASSES_CLASS_ID,USERS_USER_ID) VALUES (:CC_CLASSES_CLASS_ID,:USERS_USER_ID)",
            nativeQuery = true)
    void insertUsertoClassroom(@Param("CC_CLASSES_CLASS_ID") Long CC_CLASSES_CLASS_ID, @Param("USERS_USER_ID") Long USERS_USER_ID);


}
