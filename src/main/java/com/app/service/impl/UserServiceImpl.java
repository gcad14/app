package com.app.service.impl;

import com.app.mapper.UserMapper;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
