package com.supervons.cpj.service;

import com.supervons.cpj.entity.User;
import com.supervons.cpj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> queryList() {
        List<User> queryList = userMapper.queryList();
        return queryList;
    }
}
