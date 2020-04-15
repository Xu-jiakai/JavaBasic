package edu.dataStructure;

/**
 * 功能：保存一串整数，隐藏“暴露递归”的实现
 * 不变性：
 *    1. sentinel必须永远指向一个sentinel节点;
 *    2. 如果有一个节点，那这个节点必须可以通过sentinel.next获取到;
 *    3. size变量一直随列表中节点数量变化而变化;
 */

public class SLList {
    //杜绝用户直接操作IntNode，使用private,隐藏实现细节
    private IntNode first;
    //保存当前数组长度，不用每次迭代或递归去计算长度
    private int size;
    //The first item(if it exists) is at sentinel.next.
    private IntNode sentinel;

    //Creates an empty SLList.
    public SLList(){
        //创建一个哨兵节点
        //没有这个节点，直接创建一个空数组，在数组最后添加新元素的时候会触发空指针异常;
        //因为在最后创建新元素会判断next是否为空，空数组的next为空;
        sentinel=new IntNode(63,null);
        size=0;
    }

    public SLList(int x){
        sentinel=new IntNode(63,null);
        sentinel.next=new IntNode(x,null);
//        first=new IntNode(x,null);
        size=1;
    }

    //Adds x to the front of this list.
    public void addFirst(int x){
        sentinel.next=new IntNode(x,sentinel.next);
//        first=new IntNode(x,first);
        size+=1;
    }

    //Returns the first item in the list.
    public int getFirst(){
        return sentinel.next.item;
//        return first.item;
    }

    //Adds an item to the end of the list.
    public void addLast(int x){
//        IntNode p=first;
        IntNode p=sentinel;
        //Move p until it reaches ths end of the list.
        while(p.next!=null)
            p=p.next;
        p.next=new IntNode(x,null);
        size+=1;
    }

    public int mysize(){
        if (first.item==0)
            return 0;
        int count=0;
        while (first!=null){
            first=first.next;
            count++;
        }
        return count;
    }

    //Returns the size of the list that starts at IntNode p.
    private static int oldsize(IntNode p){
        if (p.next==null)
            return 1;
        return 1+oldsize(p.next);
    }

    public int oldsize(){
        return oldsize(first);
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        //Create a list of one integer,namely 10.
        SLList L=new SLList(10);
//        L.addFirst(15);
//        L.addFirst(5);
//        System.out.println(L.getFirst());
        L.addLast(20);
        System.out.println(L.size());
    }
}
