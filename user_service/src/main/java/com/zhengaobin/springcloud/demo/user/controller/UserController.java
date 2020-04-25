package com.zhengaobin.springcloud.demo.user.controller;

import com.zhengaobin.springcloud.demo.user.dao.UserDao;
import com.zhengaobin.springcloud.demo.user.entity.User;
import com.zhengaobin.springcloud.demo.user.service.UserService;
import com.zhengaobin.springcloud.demo.user.vo.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @RequestMapping("list")
     public ResultEntity list(@RequestParam(defaultValue = "1")Integer current, @RequestParam(defaultValue = "3")Integer size,String name){
        return ResultEntity.ok(userService.list(current,size,name));
    }

    @RequestMapping("save")
    public ResultEntity save(@RequestBody User user){
        userService.save(user);
        return ResultEntity.ok(true);
    }

    @RequestMapping("del")
    public ResultEntity del(Integer[] ids){
        userService.delete(ids);
        return ResultEntity.ok(true);
    }




}
