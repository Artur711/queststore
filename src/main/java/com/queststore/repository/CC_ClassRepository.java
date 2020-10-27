package com.queststore.repository;

import com.queststore.model.CC_Class;
import com.queststore.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

public interface CC_ClassRepository extends CrudRepository<CC_Class, Long> {

    List<CC_Class> findAll();

    List<CC_Class> findAllByClassIdIn(List<Long> classesId);

    CC_Class getCC_ClassByName(String name);

    @Override
    void deleteById(Long id);

    @Transactional
    @Modifying
    @Query(
            value =
                    "INSERT into CLASSROOMS_USERS (class_id,user_id) VALUES (:CC_CLASSES_CLASS_ID,:USERS_USER_ID)",
            nativeQuery = true)
    void insertUsertoClassroom(@Param("CC_CLASSES_CLASS_ID") Long CC_CLASSES_CLASS_ID, @Param("USERS_USER_ID") Long USERS_USER_ID);

    CC_Class findByClassId(Long classId);

    @Transactional
    @Modifying
    @Query(
            value =
                    "select classrooms_users.user_id from classrooms_users inner join users on classrooms_users.user_id = users.user_id where classrooms_users.class_id = :class_id and users.user_type = :user_type",
            nativeQuery = true)
    List<Integer> getUserIdFromTheClassroomAndUserType(@Param("class_id") Long class_id, @Param("user_type") Integer user_type);

    @Transactional
    @Modifying
    @Query(
            value = "DELETE FROM classrooms_users where class_id = :classId",
            nativeQuery = true)
    void removeOldMembersFromClassToBeUpdated(@Param("classId") Long classId);

    @Transactional
    @Modifying
    @Query(
            value = "select class_id from classrooms_users where user_id =:userId",
            nativeQuery = true)
    List<Long> getAllClassesIdOfTheUser(@Param("userId") Long userId);

}
