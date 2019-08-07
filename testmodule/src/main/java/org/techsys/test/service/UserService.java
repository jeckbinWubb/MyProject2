package org.techsys.test.service;

import org.techsys.test.model.UserVo;

public interface UserService {

    public UserVo findByName(String name);
}
