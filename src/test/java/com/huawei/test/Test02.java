package com.huawei.test;

public class Test02 {

    public static void main(String[] args) {

        int[] nums = {1,2,3,5};
        System.out.println(isSpiltArray(nums));

    }

    public static void sort(int[] arrayNums){
        int temp ;
        for(int i = 0;i < arrayNums.length-1;i++){
            for(int j = 0;j < arrayNums.length-i-1;j++){
                if(arrayNums[j]>arrayNums[j+1]){
                    temp = arrayNums[j];
                    arrayNums[j] = arrayNums[j+1];
                    arrayNums[j+1] = temp;
                }
            }
        }
    }

    public static boolean isSpiltArray(int nums[]){
        //先排序
        sort(nums);
        int s = 0;
        //求数组总和
        for(int i : nums){
            s += i;
        }
        for(int i = 1;i <= nums.length/2;i++){
            if(s * i % nums.length == 0 && isSuit(nums,s*i/nums.length,i,0)){
                return true;
            }
        }
        return false;
    }


    public static boolean isSuit(int[] nums,int target,int k,int startIndex){
        if(k==0)return target == 0;
        for(int i = startIndex;i < nums.length-k+1;i++){
            if(i > startIndex && nums[i] == nums[i-1])continue;
            if(isSuit(nums,target-nums[i],k-1,i+1)) {
                return true;
            }
        }
        return false;
    }

}
