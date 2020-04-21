package edu.dataStructure;

public class DIntNode {
    public DIntNode prev;
    public int item;
    public DIntNode next;

    public DIntNode(DIntNode p,int i,DIntNode n){
        prev=p;
        item=i;
        next=n;
    }
}
