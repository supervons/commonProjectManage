package com.supervons.cpj.controller;

import com.supervons.cpj.entity.APIResponse;
import com.supervons.cpj.entity.User;
import com.supervons.cpj.repository.UserInfoRepository;
import com.supervons.cpj.service.UserService;
import com.supervons.cpj.srcurity.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public APIResponse<User> loginAction(@RequestBody HashMap<String, String> map) {
        APIResponse apiResponse = null;
        System.out.println(map.get("loginId") + map.get("passWord"));
        User tempUser = userService.queryUserById(map.get("loginId"),map.get("passWord"));
        if(tempUser!=null){
            apiResponse = APIResponse.success();
            apiResponse.setData(tempUser);
            try {
                String jwtToken = JWTUtil.createToken(map.get("loginId"));
                Map jwtMap = new HashMap<String,String>();
                jwtMap.put("jwtToken",jwtToken);
                apiResponse.setAuxiliaryData(jwtMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            apiResponse = APIResponse.fail("登录失败，用户名或密码错误！");
        }
        return apiResponse;
    }

}