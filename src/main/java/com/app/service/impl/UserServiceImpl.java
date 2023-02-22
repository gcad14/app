package com.app.service.impl;

import com.app.mapper.UserMapper;
import com.app.model.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String getUser(String id) {
        String user = userMapper.getUserById(id);
        System.out.println(user);
        return user;
    }

    @Override
    public void inserUser(User user) {
        userMapper.inserUser(user);
    }

    @Override
    public List<User> selectList() {
        return userMapper.selectList();
    }

    @Override
    public Integer selectListByName(String name) {
        return userMapper.selectListByName(name);
    }


}
