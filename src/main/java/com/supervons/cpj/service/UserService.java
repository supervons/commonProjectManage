package com.supervons.cpj.service;

import com.supervons.cpj.entity.User;
import com.supervons.cpj.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface UserService {

    public List<User> queryUserList();

    public User queryUserById(String loginId,String passWord);


    public User queryUserExistById(String loginId);

    public int addUser(User user);
}
