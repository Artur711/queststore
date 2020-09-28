package com.queststore.dao;

import com.queststore.model.User;

import java.util.List;

public interface UserDAO {
    void create(User user);

    void update(User user);

    List<User> getAll();

    void delete(Long id);
}
