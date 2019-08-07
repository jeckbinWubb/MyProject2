package org.techsys.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techsys.test.model.UserVo;
import org.techsys.test.service.UserService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/getUserName")
    public UserVo getUserVO(String name){
        UserVo vo = userService.findByName(name);
        return vo;
    }
}
