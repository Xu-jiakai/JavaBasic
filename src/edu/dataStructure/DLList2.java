package edu.dataStructure;

/**
 * 双端单向链表（未闭环）
 */

public class DLList2 {
    private int size;
    private DIntNode2 first;
    private DIntNode2 last;

    public DLList2(){
        size=0;
        first=null;
        last=null;
    }

    public void addFirst(int item){
        DIntNode2 node=new DIntNode2(item);
        if (size>0){
            node.next=first;
        }else{
            last=node;
        }
        first=node;
        size++;
    }

    public void addLast(int item){
        DIntNode2 node=new DIntNode2(item);
        if (size>0){
            last.next=node;
        }else{
            first=node;
        }
        last=node;
        size++;
    }

    public boolean deleteHead(){
        if (size==0)
            return false;
        if (first.next==null){
            first=null;
            last=null;
        }else{
            first=first.next;
        }
        size--;
        return true;
    }
}
