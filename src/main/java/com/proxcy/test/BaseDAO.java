package com.proxcy.test;

import java.util.List;

public interface BaseDAO {

    int insert(UserInfoModel user);

    int delete(int userId);

    int update(UserInfoModel user);

    List<UserInfoModel> select();
}
