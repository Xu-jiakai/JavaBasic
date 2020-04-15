package edu.algs4;

import edu.algs4.util.Tools;

/**
 * 选择排序
 * 原理：每次选择未排序序列中的最小元素。
 *
 * 具体操作：首先在未排序序列中找到最小元素，放到序列的起始位置，然后从剩余未排序元素中寻找最小元素放到已排序序列的末尾，以此类推，直至排序完毕。
 *
 * 时间复杂度， 都是：O(n^2)
 *
 * 空间复杂度， O(1)
 *
 * 稳定性，不稳定。举个例子，序列5 8 5 2 9， 第一遍选择第1个元素5会和2交换，那么原序列中2个5的相对前后顺序就被破坏了
 */

public class SelectSort {

    public static void sort(Comparable[] a){
        for (int i=0;i<a.length;i++){
            int min=i;
            for (int j=i+1;j<a.length;j++){
                if (a[min].compareTo(a[j])>0){
                    min=j;
                }
            }
            Tools.exch(a,i,min);
        }
    }
}
