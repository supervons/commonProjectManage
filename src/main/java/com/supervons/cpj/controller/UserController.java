package com.supervons.cpj.controller;

import com.supervons.cpj.entity.User;
import com.supervons.cpj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User controller
 * Login
 * Register
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserList")
    @ResponseBody
    public List<User> queryUserList() {
        return userService.queryUserList();
    }

    @RequestMapping("/queryUserById")
    @ResponseBody
    public User queryUserById() {
        return userService.queryUserById();
    }


}