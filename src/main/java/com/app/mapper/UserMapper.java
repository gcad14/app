package com.app.mapper;

import com.app.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    String getUserById(String id);

    void inserUser(@Param("user") User user);

    List<User> selectList();

    Integer selectListByName(String name);
}
