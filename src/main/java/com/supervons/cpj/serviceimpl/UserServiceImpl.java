package com.supervons.cpj.serviceimpl;

import com.supervons.cpj.entity.User;
import com.supervons.cpj.mapper.UserMapper;
import com.supervons.cpj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList() {
        List<User> queryList = userMapper.queryList();
        return queryList;
    }

    @Override
    public User queryUserById() {
        User queryUser = userMapper.queryUserById();
        return queryUser;
    }
}
