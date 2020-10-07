package com.queststore.repository;

import com.queststore.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    User save(User user);

//    void update(User user);

    List<User> findAll();

    void delete(User user);

//    User getMentorById(long id);

    User findUserByLastNameAndPassword(String login, String password);
}
