package com.hr.array;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName : SortArray
 * Created with IDEA
 * @author:CarlLing
 * @CreateDate : 2018-11-02 10:42
 * @Description :
 * 1.冒泡排序
 * 2.直接选择排序
 * 3.反转排序
 * 4.快速排序
 */
public class SortArray {

    /**
     * 1.冒泡排序
     * @param array
     */
    public void bubbleSort(int [] array){
        for (int i = 1; i < array.length; i++){
            for(int j = 0; j < array.length - i; j++){
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        showArray(array);
    }

    /**
     *  显示排序后的元素
     * @param array  
     */
    private void showArray(int[] array) {
        for (int i : array) {
            System.out.print("\t" + i);
        }
        System.out.println();
    }

    /**
     * 2.直接选择排序 ，选中要排序的两个元素对比互换位置
     */
    public void selectSort(int [] array ){
        int index;
        for (int i = 1; i <  array.length; i++){
            index = 0;
            for (int j = 1; j <= array.length -i; j++){
                if(array[j] > array[index]){
                    index = j;
                }
            }

            int temp = array[array.length - i];
            array[array.length - i] = array[index];
            array[index] = temp;
        }

        showArray(array);
    }

    /**
     * 3.反转排序 将元素第一个和最后一个交换，第二个和最后第二个交换，以此类推
     */
    public void reverseSort(int [] array){
        System.out.println("排序前:");
        showArray(array);
        int temp;
        int len = array.length;
        for (int i = 0; i < len/2; i++){
            temp = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = temp;
        }
        System.out.println("排序后");
        showArray(array);
    }

}
