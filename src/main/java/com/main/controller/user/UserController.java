package com.main.controller.user;

import com.main.common.ResponseObject;
import com.main.controller.base.Base;
import com.main.serivce.UserService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.main.model.User;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class UserController extends Base {
    @Autowired
    private UserService userService;


    @GetMapping("/select")
    String selectUser(@RequestParam Integer id) {
        User userObj = userService.selectUser(id);
        ResponseObject responseObject = new ResponseObject();
        responseObject.setData(userObj);
        responseObject.ok();
        return responseObject.getJson();
    }

    @GetMapping(value = "/selectAll", produces = "application/json; charset=utf-8")
    String selectAllUser() {
        List<User> userObj = userService.selectAllUser();
        return JSONArray.fromObject(userObj).toString();
    }

    @PostMapping("/add")
    String addUser(@RequestBody User json) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setData(json);
        responseObject.ok();
        return responseObject.getJson();
    }
}
