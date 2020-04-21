package edu.dataStructure;

/**
 * 功能：保存一串整数，隐藏“暴露递归”的实现
 * 不变性：
 *    1. sentinel必须永远指向一个sentinel节点;
 *    2. 如果有一个节点，那这个节点必须可以通过sentinel.next获取到;
 *    3. size变量一直随列表中节点数量变化而变化;
 * 存在问题：
 *    1. addLast效率差，可以新增last变量指向最后一个值，以解决这个问题;
 *        I.使用last的情况下，get、add操作效率高，remove效率低;原因是remove每次删除最后一个，都需要遍历到倒数第二个，
 *        将它的指向改为null，再将last的指向倒数第二个值;
 *        II.在使用last基础上，使用一种结构：双向连接列表（doublly-linked-list），简写DLList;
 *        与之相反的是SLList这类的单向连接列表（singly-linked-list）;
 *        使得add、remove都消耗“恒定时间”;
 *        III.在I、II基础上，会产生一个问题，last指向sentinel，那我们就得另外去处理这种复杂情况;
 *            解决方法1：首尾添加sentinel，空列表就是两个sentinel，add在两个sentinel中间;
 *            解决方法2：(闭环)使用一个sentinel，空列表时sentinel指向自己，add一个节点后，sentinel.next.next==sentinel;
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
