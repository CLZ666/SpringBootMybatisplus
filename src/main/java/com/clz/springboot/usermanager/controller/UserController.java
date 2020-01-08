package com.clz.springboot.usermanager.controller;


import com.clz.springboot.usermanager.entity.User;
import com.clz.springboot.usermanager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author clz
 * @since 2020-01-08
 */
@RestController
@RequestMapping("/usermanager/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/getuser")
    public User getUser() {
        User user = userService.getById(1);
        return user;
    }
}
