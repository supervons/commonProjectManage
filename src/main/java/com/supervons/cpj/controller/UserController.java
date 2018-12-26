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

    @ResponseBody
    @RequestMapping("/queryUserList")
    public List<User> queryUserList() {
        return userService.queryUserList();
    }

    @ResponseBody
    @RequestMapping("/queryUserById")
    public User queryUserById(@RequestParam("loginId") String loginId, @RequestParam("passWord") String passWord) {
        return userService.queryUserById(loginId,passWord);
    }

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }


}