package com.proxcy.test;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        /*ProxyStudentDao psd = new ProxyStudentDao();
        psd.insert(new Student());*/

        //代理StudentDao对象
        BaseDAO studentDao = (BaseDAO) Proxy.newProxyInstance(new StudentDao().getClass().getClassLoader(), new StudentDao().getClass().getInterfaces(),
                new DynamicProxyBaseDao(new StudentDao()));

        studentDao.update(new Student());

        //代理String对象
        String str = "我是天使，我怕谁！";
        CharSequence strObje = (CharSequence) Proxy.newProxyInstance(str.getClass().getClassLoader(), str.getClass().getInterfaces(),
                new DynamicProxyBaseDao(str));
        System.out.println(strObje.length());
    }
}
