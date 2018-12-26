package com.supervons.cpj.mapper;

import com.supervons.cpj.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> queryList();

    User queryUserById();

}
