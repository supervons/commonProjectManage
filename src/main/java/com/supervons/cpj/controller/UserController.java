package com.supervons.cpj.controller;

import com.supervons.cpj.entity.User;
import com.supervons.cpj.repository.UserInfoRepository;
import com.supervons.cpj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private UserInfoRepository userInfoRepository;

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public List<User> deleteUser(@RequestBody User user) {
        userInfoRepository.delete(user);
        return userInfoRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        return userInfoRepository.saveAndFlush(user);
    }

    @ResponseBody
    @RequestMapping("/queryUserById")
    public Optional<User> queryUserById(@RequestParam("id") String id) {
        return userInfoRepository.findById(id);
    }

    @ResponseBody
    @RequestMapping("/queryUserList")
    public List<User> queryUserList() {
        return userInfoRepository.findAll();
    }

    @ResponseBody
    @RequestMapping("/loginAction")
    public User loginAction(@RequestParam("loginId") String loginId, @RequestParam("passWord") String passWord) {
        return userService.queryUserById(loginId,passWord);
    }


}