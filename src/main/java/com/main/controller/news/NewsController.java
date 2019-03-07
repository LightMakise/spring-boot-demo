package com.main.controller.news;

import com.main.common.ResponseObject;
import com.main.controller.base.Base;
import com.main.model.News;
import com.main.serivce.NewsService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class NewsController extends Base {
    @Autowired
    private NewsService newsService;
    @GetMapping("/news/select")
    String selectNews(@RequestParam Integer id) {
        News newsObj = newsService.selectNews(id);
        ResponseObject responseObject = new ResponseObject();
        responseObject.setData(newsObj);
        responseObject.ok();
        return responseObject.getJson();
    }
//
//    @GetMapping(value = "/selectAll", produces = "application/json; charset=utf-8")
//    String selectAllUser() {
//        List<User> userObj = userService.selectAllUser();
//        return JSONArray.fromObject(userObj).toString();
//    }

    @PostMapping("/news/add")
    String add(@RequestBody News json) {
        ResponseObject responseObject = new ResponseObject();
        Date sqlDate = new java.sql.Date(new Date().getTime());
        json.setCreateTime(sqlDate);
        Integer id = newsService.add(json);
        if(id > 0) {
            responseObject.setData("添加成功");
            responseObject.ok();
        }else{
            responseObject.setData("添加失败");
            responseObject.fail();
        }
        responseObject.setMessage(json.toString());
        return responseObject.getJson();
    }
}
