package edu.dataStructure;

/**
 * 存在问题：获取元素需要递归的获取，降低可使用性，存在出错可能性;（暴露的递归数据结构）
 */

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f ,IntList r){
        first=f;
        rest=r;
    }

    //递归（recursive）
    public int size(){
        if (rest==null)
            return 1;
        return 1+this.rest.size();
    }

    //迭代
    public int iterativeSize(){
        IntList p=this;
        int totalSize=0;
        while(p!=null){
            totalSize+=1;
            p=p.rest;
        }
        return totalSize;
    }

    public int get(int i){
        if (i==0)
            return first;
        return rest.get(i-1);
    }

    //新建数组，不影响原来数组
    public static IntList incrList(IntList l,int x){
        if (l==null)
            return null;
        IntList res=new IntList(l.first+x,null);
        IntList ptr=res;
        l=l.rest;

        while(l !=null){
            ptr.rest=new IntList(l.first+x,null);
            ptr=ptr.rest;
            l=l.rest;
        }
        return res;
    }

    //不新建数组，在原来数组上修改
    public static IntList dincrList(IntList l,int x){
        if (l==null)
            return null;
        IntList ptr=l;
        while (ptr!=null){
            ptr.first+=x;
            ptr=ptr.rest;
        }
        return l;
    }

    public static void main(String[] args) {
        IntList L=new IntList(15,null);
        L=new IntList(10,L);
        L=new IntList(5,L);

//        System.out.println(L.size());
//        System.out.println(L.iterativeSize());


        System.out.println(IntList.dincrList(L,2).get(1));
        System.out.println(L.get(2));

//        IntList L=new IntList();
//        L.first=5;
//        L.rest=null;
//
//        L.rest=new IntList();
//        L.rest.first=10;
//
//        L.rest.rest=new IntList();
//        L.rest.rest.first=15;
    }
}
