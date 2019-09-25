package com.test.practise;


import java.util.Date;
import java.util.Random;

/**
 * 经典算法练习
 * @author bingbing.wu
 */
public class AlgorithmPractise {

    public static void main(String[] args) {
        int start = 1; int end = 10; double[] temp; long time;
        Random random = new Random();
        int[] nums = random.ints(8, start, end).toArray();
        time = System.currentTimeMillis();
        //bubbleSort(nums); //冒泡排序
        selectionSort(nums); //选择排序
        System.out.println("冒泡排序花费时间： " + (System.currentTimeMillis() - time) + "ms");
        for(int i = 0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

    }


    /**
     * 冒泡排序算法
     * 算法描述：
     * 1、比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 3、针对所有的元素重复以上的步骤，除了最后一个；
     * 4、重复步骤1~3，直到排序完成。
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array){
        if(array.length==0){
            return null;
        }
        int temp;
        boolean flag ;
        for(int i = 0; i < array.length; i++){
            flag = false;
            /*for(int j = 0;j < array.length - 1 - i;j++){  //顺序冒泡
                if(array[j+1] < array[j]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }*/
            for(int j = array.length-1;j > i;j--){ //倒序冒泡
                if (array[j] < array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    flag = true;
                }
            }
            if(!flag)break;
        }
        return array;
    }


    /**
     * 选择排序算法
     * 算法描述：
     * 1、在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 2、再从剩余未排序元素中继续寻找最小（大）元素；
     * 3、然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array){
        if(array.length == 0){
            return null;
        }
        int temp;
        //最小元素法
        /*for(int i = 0;i < array.length;i++){
            int minIndex = i;
            for(int j = i + 1;j < array.length;j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }*/
        //最大元素法
        for(int i = array.length;i > 0;i--){
            int maxIndex = i - 1;
            for(int j = i;j > 0;j--){
                if(array[j-1] > array[maxIndex]){
                    maxIndex = j-1;
                }
            }
            if (maxIndex != i - 1){
                temp = array[maxIndex];
                array[maxIndex] = array[i-1];
                array[i-1] = temp;
            }


        }
        return array;
    }




    public static int[] insertedSort(int[] array){
        if(array.length == 0){
            return null;
        }

        return array;
    }

}
