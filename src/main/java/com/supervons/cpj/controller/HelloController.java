package com.supervons.cpj.controller;

import com.supervons.cpj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.supervons.cpj.entity.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class HelloController {

    @Autowired
    private UserService userService;
//
    @RequestMapping("/hello")
    private String index(){
        return "Hello World!";
    }

    @GetMapping("/getString")
    public String getString() {
        return "Hello 张三s";
    }

    @RequestMapping("/queryUserList")
    @ResponseBody
    public List<User> queryUserById() {
        return userService.queryList();
    }
}