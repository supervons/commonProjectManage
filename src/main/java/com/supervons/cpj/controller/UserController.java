package com.supervons.cpj.controller;

import com.supervons.cpj.entity.User;
import com.supervons.cpj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public User queryUserById(@RequestParam("loginId") String loginId, @RequestParam("passWord") String passWord) {
        return userService.queryUserById(loginId,passWord);
    }


}