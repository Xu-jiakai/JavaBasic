package edu.algs4.util;

public class Tools {
    //打印数组
    public static void show(Comparable[] a){
        for (Comparable anA:a){
            System.out.print(anA+"\t");
        }
        System.out.println("数组长度："+a.length);
    }

    //交换数组内两个位置的值
    public static void exch(Comparable[] a,int x,int y){
        Object tmp;
        tmp=a[x];
        a[x]=a[y];
        a[y]=(Comparable)tmp;
    }

    //判断大小
    public static boolean less(Comparable a,Comparable b){
        return a.compareTo(b)<0;
    }

    public static void main(String[] args) {
        Integer [] a={2,2};
        boolean x=less(a[0],a[1]);
        System.out.println(x);
    }
}
