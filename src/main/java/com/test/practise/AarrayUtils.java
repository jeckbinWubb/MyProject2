package com.test.practise;

import java.util.Random;

/**
 * �������һ������  �������û�����Ĳ���
 * @author aura-bd
 *
 */
public class AarrayUtils {
	public static int[] getArray(int len){
		Random ran = new Random();
		//初始化一个数组
		int[] array = new int[len];
		//1、遍历给数组赋值
		/*for(int i=0;i<len;i++){
			array[i]=ran.nextInt(100);
		}*/
		//2、直接生成一个随机数组
		int startNum = 0;
		int endNum = 100;
		array = ran.ints(len,startNum,endNum).toArray();
		return array;
	}
	
	public static void printAarray(int[] arr){
		for(int a:arr){
			System.out.print(a+"\t");
		}
		System.out.println();
	}

}
