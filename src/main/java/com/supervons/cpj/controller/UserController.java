package com.supervons.cpj.controller;

import com.supervons.cpj.entity.APIResponse;
import com.supervons.cpj.entity.User;
import com.supervons.cpj.repository.UserInfoRepository;
import com.supervons.cpj.service.UserService;
import com.supervons.cpj.srcurity.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(description = "用户相关接口")
public class UserController {
    APIResponse apiResponse = null;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ApiOperation(value = "新增用户接口", notes = "根据手机号密码注册用户，且校验重复性")
    public APIResponse<User> addUser(@ApiParam(required = true, value = "用户信息map，包含loginId与passWord两个字符串") @RequestBody HashMap<String, String> map) {
        User tempUser = userService.queryUserExistById(map.get("loginId"));
        if (tempUser != null) {
            apiResponse = APIResponse.fail("该手机号已存在，请更换手机号后尝试！");
        } else {
            User newUser = new User();
            newUser.setLoginId(map.get("loginId"));
            newUser.setPassWord(map.get("passWord"));
            int result = userService.addUser(newUser);
            if (result == 1) {
                Map resultMap = new HashMap<String, String>();
                resultMap.put("resultMsg", "注册成功！");
                apiResponse = APIResponse.success(resultMap);
            } else {
                apiResponse = APIResponse.fail("注册失败！");
            }
        }
        return apiResponse;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public List<User> deleteUser(@RequestBody User user) {
        userInfoRepository.delete(user);
        return userInfoRepository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public APIResponse<User> updateUser(@RequestBody User user) {
        User saveUser = userInfoRepository.saveAndFlush(user);
        if (saveUser != null) {
            apiResponse = APIResponse.success();
            apiResponse.setMsg("保存成功");
        } else {
            apiResponse = APIResponse.fail("保存失败");
        }
        return apiResponse;
    }

    @ResponseBody
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public APIResponse<User> updatePassword(@RequestBody HashMap<String, String> map) {
        // 校验用户名及原密码是否正确
        User tempUser = userService.queryUserById(map.get("loginId"), map.get("oldPassword"));
        if (tempUser != null) {
            String newPassword = map.get("newPassword");
            tempUser.setPassWord(newPassword);
            userInfoRepository.saveAndFlush(tempUser);
            apiResponse = APIResponse.success();
            apiResponse.setMsg("修改密码成功！");
        } else {
            apiResponse = APIResponse.fail("原密码不正确，请重新输入！");
        }
        return apiResponse;
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
        User tempUser = userService.queryUserById(map.get("loginId"), map.get("passWord"));
        if (tempUser != null) {
            apiResponse = APIResponse.success();
            apiResponse.setData(tempUser);
            try {
                String jwtToken = JWTUtil.createToken(map.get("loginId"));
                Map jwtMap = new HashMap<String, String>();
                jwtMap.put("jwtToken", jwtToken);
                apiResponse.setAuxiliaryData(jwtMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            apiResponse = APIResponse.fail("登录失败，用户名或密码错误！");
        }
        return apiResponse;
    }

}