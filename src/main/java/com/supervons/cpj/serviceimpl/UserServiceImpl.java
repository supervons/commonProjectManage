package com.supervons.cpj.serviceimpl;

import com.supervons.cpj.entity.User;
import com.supervons.cpj.mapper.UserMapper;
import com.supervons.cpj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList() {
        List<User> queryList = userMapper.queryList();
        return queryList;
    }

    @Override
    public User queryUserById(String username,String password) {
        User queryUser = userMapper.queryUserById(username,password);
        return queryUser;
    }

    @Override
    public User queryUserExistById(String username) {
        User queryUser = userMapper.queryUserExistById(username);
        return queryUser;
    }

    @Override
    public int addUser(User user){
        user.setId(UUID.randomUUID().toString().replace("-",""));
        int result  = userMapper.addUser(user);
        return result;
    }
}
