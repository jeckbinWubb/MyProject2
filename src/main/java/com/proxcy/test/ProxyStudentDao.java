package com.proxcy.test;

import java.util.List;

/**
 * 静态代理方法
 */

public class ProxyStudentDao implements BaseDAO{

    private StudentDao stDao;


    public ProxyStudentDao(){
        this.stDao = new StudentDao();
    }

    @Override
    public int insert(UserInfoModel user) {
        System.out.println("开始插入数据！");
        int ret = stDao.insert(user);
        System.out.println("数据插入成功！");
        return ret;
    }

    @Override
    public int delete(int userId) {
        System.out.println("开始删除数据！");
        int ret = stDao.delete(userId);
        System.out.println("数据删除成功！");
        return ret;
    }

    @Override
    public int update(UserInfoModel user) {
        System.out.println("开始更新数据！");
        int ret = stDao.update(user);
        System.out.println("数据更新成功！");
        return ret;
    }

    @Override
    public List<UserInfoModel> select() {
        System.out.println("开始查询数据！");
        List<UserInfoModel> list = stDao.select();
        System.out.println("数据更新成功！");
        return  list;
    }
}
