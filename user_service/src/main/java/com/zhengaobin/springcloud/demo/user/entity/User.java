package com.zhengaobin.springcloud.demo.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "lx_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.NATURAL,pattern ="yyyy-MM-dd",timezone = "GMT+08")
    private Date birthday;

    @Column(name = "create_time")
    @JsonFormat(shape = JsonFormat.Shape.NATURAL,pattern ="yyyy-MM-dd",timezone = "GMT+08")
    private Date createTime;

    @Column
    private String tests;
}
