package com.proxcy.test;

import java.util.List;

public class StudentDao implements BaseDAO{
    @Override
    public int insert(UserInfoModel user) {
        System.out.println("----------插入一条学生的信息-------");
        return user == null?0:1;
    }

    @Override
    public int delete(int userId) {
        System.out.println("----------删除一条学生的信息-------");
        return 0;
    }

    @Override
    public int update(UserInfoModel user) {
        System.out.println("----------更新一条学生的信息-------");
        return user == null?0:1;
    }

    @Override
    public List<UserInfoModel> select() {
        System.out.println("----------查询所有的学生信息-------");
        return null;
    }
}
