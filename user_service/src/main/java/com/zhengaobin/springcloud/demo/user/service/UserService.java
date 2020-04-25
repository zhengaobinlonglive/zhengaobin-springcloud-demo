package com.zhengaobin.springcloud.demo.user.service;

import com.zhengaobin.springcloud.demo.user.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<User> list(Integer current, Integer size,String name);

    void save(User user);

    void delete(Integer[] ids);

}
