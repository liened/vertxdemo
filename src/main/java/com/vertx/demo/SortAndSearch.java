package com.vertx.demo;

import java.util.Arrays;

/**
 * Created by Administrator on 2017-9-11.
 */
public class SortAndSearch {

    public static void main(String[] args) {
        int[] a = {2,5,6,9,8,7,4,1,3};
        //int[] a = {0,5,3,4,6,2};
        SortAndSearch b = new SortAndSearch();

        b.insertSort(a);

        System.out.println(Arrays.toString(a));
    }



    //TODO ERROR
    public int[] shellSort(int[] a){
        int i,j;
        int increment = a.length;
        do {
            increment = increment/3+1;
            for (i = increment+1;i<a.length;i++){
                if (a[i] < a[i-increment]){
                    a[0] = a[i];
                    for (j = i-increment;j>0 && a[0]< a[j];j -= increment){
                        a[j+increment] = a[j];
                    }
                    a[j+increment] = a[0];
                }
            }
        }while (increment >1);

        return a;
    }


    //DN 的插入排序
    public int[] insertSort(int[] a){
        int i,j,t;
        for (i=1;i<a.length;i++){
            t = a[i];
            for (j = i-1;j>=0;j--){
                if (t < a[j]){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] = t;
        }

        return a;
    }

    //简单选择排序 - 先在循环里面对比，然后再比较判断是否赋值
    public int[] simpleSelectionSort(int[] a){
        int min;
        for (int i=0;i<a.length-1;i++){
            min = i;
            for (int j = i+1;j<a.length;j++){
                if (a[min] > a[j]){
                    min = j;
                }
            }
            if (i != min){
                this.swap(a,i,min);
            }
        }
        return a;
    }


    //冒泡排序 - 改造二：加了flag，如果后面已经拍好序的话不用再次遍历,【注】：此方法有弊端，如果后面没有拍好续的话，如{2,1,4,6,5}，后面也不会重新排序了，所以此方法不可取。
    @Deprecated
    public int[] bubbleSort3(int[] a){
        boolean flag = true;
        for (int i=0;i<a.length && flag;i++){
            flag = false;
            for (int j = a.length-1;j>i;j--){
                if (a[i] > a[j]){
                    this.swap(a,i,j);
                    flag = true;
                }
            }
        }
        return a;
    }

    //冒泡排序 - 改造一：从后面开始遍历 正宗的
    public int[] bubbleSort2(int[] a){
        for (int i = 0;i<a.length;i++){
            for (int j= a.length-1;j>i;j--){
                if (a[i] >a[j]){
                    this.swap(a,i,j);
                }
            }
        }
        return a;
    }

    //冒泡排序 - 简单的
    public int[] bubbleSort1(int[] a){
        for (int i=0;i<a.length;i++){
            for (int j = i+1;j<a.length;j++){
                if (a[i] > a[j]){
                   this.swap(a,i,j);
                }
            }
        }
        return a;
    }

    public int[] swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        return a;
    }

    /**
     * 对折查找
     * @param a 要查找的数组
     * @param n 元素个数
     * @param key 要查找的数
     * @return
     */
    public int search(int[] a,int n,int key){
        int low,high,mid;
        low = 1;
        high = n;
        while (low <= high){
            //mid = (low+high)/2;
            mid = low + (high - low) * (key - a[low]) / (a[high]-a[low]);
            if (key < a[mid]){
                high = mid-1;
            }else if (key > a[mid]){
                low = mid +1;
            }else{
                return mid;
            }
        }
        return 0;
    }
}
