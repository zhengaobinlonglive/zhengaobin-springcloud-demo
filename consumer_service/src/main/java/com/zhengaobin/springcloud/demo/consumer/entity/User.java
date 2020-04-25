package com.zhengaobin.springcloud.demo.consumer.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Integer id;
    private String username;
    private String password;
    private String tests;

}
