package com.test.practise;


import com.sun.tools.javac.util.ArrayUtils;

/**
 * 快速排序
 */
public class QuicklySorctTest {
    public static void main(String[] args) {
       int[] srcArray = AarrayUtils.getArray(10);
       AarrayUtils.printAarray(srcArray);
       quicklySort(srcArray,0,srcArray.length-1);
       AarrayUtils.printAarray(srcArray);
    }


    /**
     * 获取基准点
     * @param srcArray   获取基准点的数组
     * @param leftIndex  拆分的小数组的最左侧的下标（Index）
     * @param rightIndex 拆分的小数组的最右侧的下标（Index）
     * @return
     */
    public static int getIndex(int[] srcArray,int leftIndex,int rightIndex){
        //定义一个初始基准点
        int key = srcArray[leftIndex];
        //循环遍历比较
        while(leftIndex < rightIndex){
            //从右向左，比基准点大，向左移动
            while(srcArray[rightIndex] > key && leftIndex < rightIndex ){
                rightIndex--;
            }
            //未进入循环的，比基准点小，则把rigthIndex的值赋给leftIndex
            srcArray[leftIndex] = srcArray[rightIndex];
            //从左向右，比基准点小，向右移动
            while(srcArray[leftIndex] < key && leftIndex < rightIndex){
                leftIndex++;
            }
            //未进入循环，比基准点大，则把leftIndex的值赋给rightIndex
            srcArray[rightIndex] = srcArray[leftIndex];
        }
        //对基准点重新赋值
        srcArray[leftIndex] = key;
        return  leftIndex;
    }

    /**
     * 快速排序，递归操作，找出口
     * @param srcArray
     * @param leftIndex
     * @param rightIndex
     */
    public static void quicklySort(int[] srcArray,int leftIndex,int rightIndex){
        if(leftIndex >= rightIndex){
            return;
        }
        //获取基准点
        int pointKey = getIndex(srcArray,leftIndex,rightIndex);
        //基准点左侧排序，拆分的小数组进行递归操作
        quicklySort(srcArray,leftIndex,pointKey-1);
        //基准点右侧排序，拆分的小数组进行递归操作
        quicklySort(srcArray,pointKey+1,rightIndex);
    }
}
