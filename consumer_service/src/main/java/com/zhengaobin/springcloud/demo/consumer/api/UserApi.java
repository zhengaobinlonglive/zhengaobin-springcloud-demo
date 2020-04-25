package com.zhengaobin.springcloud.demo.consumer.api;

import com.github.pagehelper.Page;
import com.zhengaobin.springcloud.demo.consumer.entity.User;
import com.zhengaobin.springcloud.demo.consumer.vo.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-service")
public interface UserApi {

    @RequestMapping("list")
    ResultEntity list(@RequestParam(defaultValue = "1")Integer current, @RequestParam(defaultValue = "3")Integer size);

    @RequestMapping("save")
    ResultEntity save(@RequestBody User user);

}
