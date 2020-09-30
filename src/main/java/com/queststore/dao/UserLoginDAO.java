package com.queststore.dao;

import com.queststore.model.User;

public interface UserLoginDAO {
    User getUser(String login, String password);
}
