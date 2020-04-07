package com.test.practise;

import org.techsys.test.model.UserVo;

import java.lang.reflect.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestReflectDemon {
    public static void main(String[] args) {
        System.out.println(int[].class.isPrimitive());
        Class userClazz = UserVo.class;
        try {
            /**
             * 1、无参构造方法
             */
            //通过类的描述信息获取类的构造器对象
            Constructor constructor = userClazz.getConstructor(null);
            //通过累的构造器对象创建类的实例对象
            UserVo userVo = (UserVo) constructor.newInstance();
            userVo.setId("100001");
            userVo.setName("zhangsan");
            userVo.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1990-12-20"));
            userVo.setCertitype("01");
            userVo.setCerticode("100111222010");
            userVo.setGender("F");
            System.out.println(userVo);
            /**
             * 2、有参构造方法
             */
            //getConstructor()方法中加入参数类型
            Constructor constructor1 = userClazz.getConstructor(String.class,String.class,String.class, Date.class,String.class,String.class);
            //填充构参值
            UserVo userVo1 = (UserVo) constructor1.newInstance("100002","lisi","M",new SimpleDateFormat("yyyy-MM-dd").parse("1990-10-20"),"02","1002220123");
            System.out.println(userVo1);
            /**
             * 3、获取所有构造器方法
             */
            Constructor[] constructors = userClazz.getConstructors();
            System.out.println("类UserVo的构造方法包括: ");
            for(Constructor constructor2 : constructors){
                System.out.println(Modifier.toString(constructor2.getModifiers())); //打印该构造方法的修饰符
                System.out.println(" "+constructor2.getName()+"("); //打印该构造方法的名字
                Class[] parameterTypes=constructor2.getParameterTypes(); //打印构造方法的参数
                for(int j=0;j<parameterTypes.length;j++) {
                    System.out.print(parameterTypes[j].getName());
                }
                System.out.println(")");
            }

            /**
             * 获取类中的方法
             */
            System.out.println("======获取类的方法=======");
            Method[] methods = userClazz.getMethods();
            for(Method method : methods){
                System.out.println("方法名称："+method.getName());
                Class<?>[] methodPara = method.getParameterTypes();
                System.out.println("该方法参数类型：");
                for(Class clazz : methodPara){
                    System.out.println(clazz.getName());
                }
            }
            Method firstmethod = userClazz.getMethod("setName", String.class);
            firstmethod.invoke(userVo1,"吴兵兵");
            System.out.println(userVo1);

            /**
             * 获取类中的属性
             */
            System.out.println("=======获取属性=======");
            Field field1 = userClazz.getDeclaredField("name");
            field1.setAccessible(true); //开启私有属性授权
            field1.set(userVo1,"aaaa");
            //Field[] fields = userClazz.getFields();  //只能获取共有属性
            Field[] fields = userClazz.getDeclaredFields();  //既可以获取共有属性也可以获取私有属性
            for(Field field : fields){
                System.out.println(field.getName());
                field.setAccessible(true);
                Class fieldType = field.getType();
                if(fieldType == Date.class){
                    field.set(userVo1,new Date());
                }else if(fieldType == String.class){
                    field.set(userVo1,"aaa");
                }
            }
            System.out.println(userVo1);


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
