package com.huawei.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        String str = "";
        str.substring(0);
        System.out.println("请输入数字：");
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int nextInt = sc.nextInt();
        if(nextInt != 0){
            list.add(nextInt);
        }
        while(nextInt != 0){
            int nextInt2 = sc.nextInt();
            if(nextInt2 != 0){
                list.add(nextInt2);
            }
            nextInt = nextInt2;
        }
        for(int i = 0;i < list.size();i++){
            System.out.println(getLine(list.get(i)));
        }
        System.out.println("end");
    }

    private static int getLine(Integer num) {
        int all = 0;
        for(int i = 2;i <= num/2;i++){
            if(print(i) && print(num - i)){
                all = all + 1;
            }
        }
        return all;
    }

    private static boolean print(int num) {
        boolean flag = true;
        double sqrt = Math.sqrt(num);
        if(num == 2 || num ==3){

        }else{
            for(int i = 2; i <= sqrt;i++){
                if(num%i==0){
                    flag = false;
                    break;
                }
            }
        }
        return  flag;
    }


}
