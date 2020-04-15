package edu.algs4;

import edu.algs4.util.Tools;

/**
 * 归并排序
 * 原理：将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 *
 * 具体操作：把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别递归调用归并排序（终止条件是只有1个元素的最小子序列，两个最小子序列直接merge）；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 *
 * 时间复杂度， 都是：O(nlogn)。通过使用插入排序来处理小规模子序列(如长度小于15)一般可以提升归并排序的效率10%~15%
 *
 * 空间复杂度， O(n)
 *
 * 稳定性，稳定
 */

public class MergeSort {
    public static void sort(Comparable[] a){
        Integer[] temp=new Integer[a.length];
        sort(a,0,a.length-1,temp);
    }

    private static void sort(Comparable[] a,int left,int right,Comparable[] temp){
        if (left<right){
            int mid=(left+right)/2;
            sort(a,left,mid,temp);
            sort(a,mid+1,right,temp);
            merge(a,left,mid,right,temp);
        }
    }

    private static void merge(Comparable[] a,int left,int mid,int right,Comparable[] temp){
        int i=left;
        int j=mid+1;
        int t=0;
        while(i<=mid && j<=right){
             if (Tools.less(a[i],a[j])){
                temp[t++]=a[i++];
            }else{
                temp[t++]=a[j++];
            }
        }
         while (i<=mid){
            temp[t++]=a[i++];
        }
         while (j<=right){
            temp[t++]=a[j++];
        }
        t=0;
         while (left<=right){
            a[left++]=temp[t++];
        }
    }
}
