package edu.algs4.test;

import edu.algs4.InsertSort;
import edu.algs4.MergeSort;
import edu.algs4.util.Tools;

public class Test {
    public static void main(String[] args) throws IllegalAccessException,InstantiationException{
        Integer [] a={13,16,20,3,4,7,9,12,32,1};
        Tools.show(a);
//        BubbleSort.sort(a);
//        SelectSort.sort(a);
        InsertSort.sort(a);
//        MergeSort.sort(a);
        Tools.show(a);
    }
}
