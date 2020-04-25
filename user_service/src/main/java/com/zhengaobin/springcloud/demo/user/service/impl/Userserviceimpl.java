package com.zhengaobin.springcloud.demo.user.service.impl;

import com.zhengaobin.springcloud.demo.user.dao.UserDao;
import com.zhengaobin.springcloud.demo.user.entity.User;
import com.zhengaobin.springcloud.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class Userserviceimpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Page<User> list(Integer current, Integer size,String name) {
        Specification specification=new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder cd) {
                List<Predicate> predicates = new ArrayList<>();
                if(!StringUtils.isEmpty(name)){
                    predicates.add(cd.like(root.get("username"),"%".concat(name).concat("%")));
                }
                return cd.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        Pageable of = PageRequest.of(current-1,size);
        return userDao.findAll(specification,of);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }


    @Override
    public void delete(Integer[] ids) {
        for (int i = 0; i < ids.length; i++) {
            userDao.deleteById(ids[i]);
        }
    }
}
