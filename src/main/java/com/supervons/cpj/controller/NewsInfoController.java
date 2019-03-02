package com.supervons.cpj.controller;

import com.supervons.cpj.entity.NewsInfo;
import com.supervons.cpj.entity.User;
import com.supervons.cpj.repository.NewsInfoRepository;
import com.supervons.cpj.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 新闻相关 controller
 */
@RestController
@RequestMapping("/news")
public class NewsInfoController {

    @Autowired
    private NewsInfoRepository newsInfoRepository;
    @RequestMapping(value = "/queryNewsInfo", method = RequestMethod.POST)
    public List<NewsInfo> queryNewsInfo(@RequestBody NewsInfo newsInfo) {
        return newsInfoRepository.findAll();
    }
}
