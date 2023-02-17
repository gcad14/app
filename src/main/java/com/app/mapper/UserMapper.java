package com.app.mapper;

import com.app.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from t_user where id = #{id}")
    User getUserById(Integer id);
}
