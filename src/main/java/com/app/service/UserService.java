package com.app.service;


import com.app.model.User;

import java.util.List;

public interface UserService {
    String getUser(String id);

    void inserUser(User user);

    List<User> selectList();

    Integer selectListByName(String name);

}
