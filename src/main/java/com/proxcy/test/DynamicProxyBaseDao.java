package com.proxcy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理类
 */
public class DynamicProxyBaseDao implements InvocationHandler {

    private Object obj;

    public DynamicProxyBaseDao(Object obj){
        this.obj = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodNmae = method.getName();
        Object ret = null;
        if("insert".equals(methodNmae)){
            System.out.println("开始插入数据！");
            ret = method.invoke(obj,args);
            System.out.println("插入数据成功！");
        }else{
            System.out.println("处理数据！");
            ret = method.invoke(obj,args);
            System.out.println("数据处理完毕！");
        }
        return ret;
    }
}
