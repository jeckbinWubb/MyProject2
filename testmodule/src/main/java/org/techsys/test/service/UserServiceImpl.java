package org.techsys.test.service;

import org.springframework.stereotype.Service;
import org.techsys.test.dao.UserDAO;
import org.techsys.test.model.UserVo;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDAO userDAO;


    public UserVo findByName(String name){
        return userDAO.findById(name);
    }
}
