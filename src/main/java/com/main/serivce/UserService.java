package com.main.serivce;

import com.main.model.User;

import java.util.List;

public interface UserService {
    //添加用户
    int addUser(User user);
    //查询单一用户
    User selectUser(Integer id);
    //查询所有用户
    List<User> selectAllUser();
}
