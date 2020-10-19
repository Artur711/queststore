package com.queststore.repository;

import com.queststore.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findUserByLastNameAndPassword(String login, String password);
}
