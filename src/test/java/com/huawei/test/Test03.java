package com.huawei.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strInput = sc.nextLine();
        String[] str = strInput.split(",");
        System.out.println(checkReverse(str[0],str[1]));


    }


    public static boolean checkReverse(String s1,String s2){
        byte[] str1 = s1.getBytes();
        byte[] str2 = s2.getBytes();
        Arrays.sort(str1);
        Arrays.sort(str2);
        if(Arrays.equals(str1,str2)){
            return true;
        }
        return false;
    }
}
