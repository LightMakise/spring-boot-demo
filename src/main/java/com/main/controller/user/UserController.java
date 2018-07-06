package com.main.controller.user;

import com.main.common.ResponseObject;
import com.main.controller.base.Base;
import com.main.serivce.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.main.model.User;

import java.util.List;
import java.util.Map;

@RestController
public class UserController extends Base {
    @Autowired
    private UserService userService;


    @GetMapping("/select")
    String selectUser(@RequestParam Integer id){
        User userObj = userService.selectUser(id);
        ResponseObject responseObject = new ResponseObject();
        responseObject.setData(userObj);
        responseObject.ok();
        return responseObject.getJson();
    }
    @GetMapping(value = "/selectAll",produces = "application/json; charset=utf-8")
    String selectAllUser(){
        List<User> userObj = userService.selectAllUser();
        return JSONArray.fromObject(userObj).toString();
    }
}
