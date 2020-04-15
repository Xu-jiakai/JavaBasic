package edu.algs4;

/**
 * 冒泡排序
 * 原理：依次比较相邻的两个数，将小数放在前面（左边），大数放在后面（右边），就像冒泡一样
 *
 * 具体操作：第一趟，首先比较第1个和第2个数，将小数放前，大数放后。然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，
 * 直至比较最后两个数，将小数放前，大数放后，这样第一趟下来最大的数就在最后一位了。
 * 然后还是从第一个数开始重复第一趟步骤比较，但是这次不比较最后一个数了，第二趟结束后第二大的数就在倒数第二位......以此类推，直至全部排序完成。
 *
 * 时间复杂度， 最好：正序O(n)、最坏：逆序O(n^2)、平均：O(n^2)
 *
 * 空间复杂度， O(1)
 *
 * 稳定性，因为相同的元素不会交换，所以是稳定的
 *
 * noChange：如果某一趟没有交换，说明数据已经排好序无需再进行接下来的排序
 */

public class BubbleSort {

    private BubbleSort(){}

    public static void sort(Comparable[] a) throws IllegalAccessException,InstantiationException{
        Object tmp;
        boolean noChange=false;
        for (int i=0;i<a.length-1 && !noChange;i++){
            noChange=true;
            for (int j=0;j<a.length-1-i;j++){
                if (a[j].compareTo(a[j+1])>0){
                    tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=(Comparable)tmp;
                    noChange=false;
                }
            }
            System.out.println(noChange);
        }
    }
}
