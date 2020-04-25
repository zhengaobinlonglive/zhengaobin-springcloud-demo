package com.zhengaobin.springcloud.demo.consumer.controller;

import com.github.pagehelper.Page;
import com.zhengaobin.springcloud.demo.consumer.api.UserApi;
import com.zhengaobin.springcloud.demo.consumer.entity.User;
import com.zhengaobin.springcloud.demo.consumer.vo.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserApi userApi;

    @RequestMapping("list")
    public ResultEntity list(@RequestParam(defaultValue = "1")Integer current, @RequestParam(defaultValue = "3")Integer size){
        return userApi.list(current,size);
    }

    @RequestMapping("save")
    public ResultEntity save(@RequestBody User user){
        return userApi.save(user);
    }

}
