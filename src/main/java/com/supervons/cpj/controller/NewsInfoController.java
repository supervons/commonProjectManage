package com.supervons.cpj.controller;

import com.supervons.cpj.entity.APIResponse;
import com.supervons.cpj.entity.NewsInfo;
import com.supervons.cpj.repository.NewsInfoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  新闻相关 controller
 */
@RestController
@RequestMapping("news")
@Api(description = "新闻信息等相关接口")
public class NewsInfoController {

    @Autowired
    private NewsInfoRepository newsInfoRepository;
    @ApiOperation(value = "获取新闻列表", notes="获取新闻列表，支持动态步长与分页")
    @RequestMapping(value = "/queryNewsInfo", method = RequestMethod.POST)
    public APIResponse<List<NewsInfo>> queryNewsInfo(@RequestBody HashMap<String, String> map) {
        //初始页码和步长
        int pageNumber = Integer.parseInt(map.get("pageNo"));
        int pageSize = Integer.parseInt(map.get("itemNo"));
        int startPageNum = pageNumber * pageSize;
        //根据页码分页查询，前端得到数据追加
        List<NewsInfo> newsList = newsInfoRepository.findAllList(startPageNum,pageSize);
        Integer countNum=newsInfoRepository.countAllList();
        Map<String,Integer> countMap = new HashMap<String,Integer>();
        countMap.put("countNum",countNum);
        APIResponse apiResponse = null;
        if(newsList!=null){
            apiResponse = APIResponse.success();
            apiResponse.setData(newsList);
            apiResponse.setAuxiliaryData(countMap);
        }
        return apiResponse;
    }
}
