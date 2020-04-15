package edu.algs4;

/**
 * 快速排序
 * 原理：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，然后分别对这两部分记录进行排序，以达到整个序列有序
 *
 * 具体操作：从数列中挑出一个元素，称为 "基准"（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。
 * 这个称为分区（partition）操作；递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * 时间复杂度，最好：O(nlogn)、最坏：O(n^2)、平均：O(nlogn)。一般快于归并排序，虽然比较次数可能多些，但是移动数据次数更少。
 * 同样的小规模数据转换为插入排序会有效果提升。对于包含大量重复元素的数据，使用三向切分也能提高性能。
 *
 * 空间复杂度，最好：每次划分都在中间O(logn)、最坏：退化为冒泡O(n)
 *
 * 稳定性，不稳定，比如序列为 5 3 3 4 3 8 9 10 11， 现在中枢元素5和3(第5个元素，下标从1开始计)交换就会把元素3的稳定性打乱，
 * 所以快速排序是一个不稳定的排序算法，不稳定发生在中枢元素和a[j] 交换的时刻
 */

public class QuickSort {

    public static void main(String[] args) {
        int [] a=new int[]{5,3,1,6,2,7,4};
        sort(a,0,a.length-1);
        for (int b:a)
            System.out.print(b+" ");
    }

    public static void sort(int[] a,int left,int right){
        if (left>=right)
            return;
        int partitionIndex=partition(a,left,right);
        sort(a,left,partitionIndex-1);
        sort(a,partitionIndex+1,right);
    }

    public static int partition(int[] a,int left,int right){
        //基准，一般选最后一个
        int pivot=a[right];
        //左指针
        int leftIndex=left;
        //右指针
        int rightIndex=right-1;

        while (true){
            //左指针没有移动到最后（越界），且当前指针对应的值小于或等于基准
            while (leftIndex<right && a[leftIndex]<=pivot){
                //左指针向右移动一位
                leftIndex++;
            }
            //右指针没有移动到最后（越界），且当前指针对应的值小于或等于基准
            while (rightIndex>=left && a[rightIndex]>pivot){
                //右指针向左移动一位
                rightIndex--;
            }
            if (leftIndex > rightIndex)
                break;
            swap(a,leftIndex,rightIndex);
        }
        swap(a,leftIndex,right);
        return leftIndex;
    }

    public static void swap(int[] a,int left,int right){
        int temp=a[left];
        a[left]=a[right];
        a[right]=temp;
    }
}
