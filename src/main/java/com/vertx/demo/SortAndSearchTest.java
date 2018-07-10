package com.vertx.demo;


import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017-11-7.
 */

public class SortAndSearchTest {

    private int[] a;

    @Before
    public void before(){
        System.out.println("--------- before ---------");
        a = new int[]{8,3,2,5,9,3,6};
        System.out.println(Arrays.toString(a));
        System.out.println("--------------------------");
    }

    @After
    public void after(){
        System.out.println("---------- after ---------");
        System.out.println(Arrays.toString(a));
        System.out.println("--------------------------");
    }

    @Test
    public void mySelection(){
        int i,j,t;
        int n= a.length;
        for (i=0;i<n-1;i++){
            t = i;
            for (j=i+1;j<n;j++){
                if (a[t]>a[j]){
                    t = j;
                }
            }
            if (t !=i){
                this.swap(a,i,t);
            }
        }
    }

    @Test
    public void myBubble(){
        for (int i = a.length-1;i>=0;i--){
            for (int j=0;j<i;j++){
                if (a[j]>a[j+1]){
                    this.swap(a,j,j+1);
                }
            }
        }
    }

    @Test
    public void halfSearch(){
        int[] as = {1,2,3,4,5,6,7,8,9,10};
        int n = 12;
        int s=0;
        int e=as.length-1;
        while(s<=e){
            int m=(s+e)/2;
            if(n==as[m]){
                System.out.println("找到了n="+n+"的下标为:"+m);
                return;
            }else if(n>m){
                s = m+1;
            }else if (n<m){
                e = m-1;
            }
        }
        System.out.println("没找到");
    }

    @Test
    public void calc(){
        int[] as = new int[3];
        int n = 12;
        as[as.length-1]=5;
        as[as.length-2]=1;
        for (int i=0;i<as.length;i++){
            as[i] = as[i]*12;
        }
        for (int i=as.length-1;i>0;i--){
            as[i-1] += as[i]/10;
            as[i]=as[i]%10;
        }
        System.out.println(Arrays.toString(as));
        System.out.println("==============");

        //查找第一个不为零的位
        int t = 0;
        for (int i=0;i<as.length;i++){
            int temp = as[i];
            if(temp != 0){
                t = i;
                break;
            }
        }

        for (int i=t;i<as.length;i++){
            System.out.print(as[i]);
        }
        System.out.println();

    }
    @Test
    public void myInsert3(){
        int i,j,t;
        for (i=1;i<a.length;i++){
            t=i;
            for (j=t-1;j>=0;j--){
                if (a[t]<a[j]){
                   // this.swap(t,j);
                    t = j;
                }
            }
        }
    }

    @Test
    public void testInsert2(){
        int len = a.length;
        int i,j;
        for (i=1;i<len;i++){
            int t = a[i];
            for (j=i-1;j>=0 && a[j]>t;j--){
                a[j+1]=a[j];
            }
            a[j+1] = t;
        }
    }

    @Test
    public void testInsert(){
        int len = a.length;
        for (int i=1;i<len;i++){
            for (int j=0;j<i;j++){
                if (a[i]<a[j]){
                    int temp = a[i];
                    for (int k=i-1;k>=j;k--){
                        a[k+1]=a[k];
                    }
                    a[j]=temp;
                    break;
                }
            }
        }
    }

    @Test
    public void testBubble(){
        int len = a.length;
        int i,j,k;
        for (i=len-1;i>0;i=k){
            for (k=j=0;j<i;j++){
                if (a[j]>a[j+1]){
                    this.swap(a,j,j+1);
                    k = j;
                }
            }
        }
    }

    @Test
    public void selection(){
        int n = a.length;
        int i,j,k;
        for (i=0;i<n-1;i++){
            k = i;
            for (j=i+1;j<n;j++){
                if (a[k]>a[j]){
                    k = j;
                }
            }
            if (k!=j && k!=i){
                this.swap(a,k,i);
            }
        }
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void testCalc(){
        System.out.println("===============testCalc==============");
        int[] as = new int[4];
        int n1 = 124;
        for (int i=as.length-1;i>=0;i--){
            as[i]=n1%10;
            n1 = n1/10;
        }
        int n2 = 13;
        for (int i=as.length-1;i>0;i--){
            as[i]=as[i]*n2;
            //as[i]
        }


        System.out.println("as:"+Arrays.toString(as));
        System.out.println("===============testCalc==============");
    }

    @Test
    public void testNorSearch(){
        int n = 2;//要找的数
        int s = a[0];
        if (s==n){
            System.out.println("上来就找到了 t:0");
        }else{
            int t = this.ss(n);
            if (t ==0){
                System.out.println("没找到");
            }else{
                System.out.println("==== t:"+t);
            }
        }
        a[0]=s;
    }

    /**
     * 这个方法就是省去了每一步都判断是否相等
     * @param k
     * @return
     */
    public int ss(int k){
        int i = a.length-1;
        a[0]=k;
        while(a[i] != k){
            i--;
        }
        return i;
    }

    @Test
    public void testShell2(){
        a = new int[]{4,3,2,1};
        System.out.println("init:"+Arrays.toString(a));
        int i,j,k;
        int t;
        int n = a.length;
        k = n/2;
        while (k>0){
            for (i = k;i<n;i++){
                t = a[i];
                for (j = i-k;j>=0 && a[j] > t;j -=k){
                    a[j+k] = a[j];
                }
                a[j+k] = t;
                System.out.println("第"+i+" 后结果是："+Arrays.toString(a));
            }
            k /=2;
        }
    }


    @Test
    public void test(){
        int[][] aa = new int[2][3];
        for (int i =0 ;i<aa.length;i++){
            System.out.println(Arrays.toString(aa[i]));
        }
        List s  = new ArrayList<>();
        Map map = new HashMap();

    }
}
