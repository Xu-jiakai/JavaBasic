package edu.dataStructure;

public class DLList {
    private int size;
    private DIntNode sentinel;

    public DLList(){
        sentinel=null;
        size=0;
    }

    public DLList(int x){
        DIntNode d=new DIntNode(x);
        sentinel=null;
        d.next=sentinel;
        d.prev=sentinel;
//        sentinel.prev=d;
//        sentinel.next=d;
        size=1;
    }

    public void addFirst(int x){
        DIntNode d=new DIntNode(x);
        if (size==0){
            sentinel.prev=d;
            sentinel.next=d;
        }else{
            d.next=sentinel.next;
            sentinel.next=d;
        }
        size+=1;
    }

    public int getFirst(){
        return sentinel.next.item;
    }

    public void addLast(int x){
        DIntNode d=new DIntNode(x);
        if (size==0){
            sentinel.prev=d;
            sentinel.next=d;
        }else{
            d.prev=sentinel.prev;
            sentinel.prev=d;
        }
        size+=1;
    }

    public int getLast(){
        return sentinel.prev.item;
    }

    public int size(){
        return size;
    }

    public void print(){
        if (sentinel.next==sentinel)
            return;
        DIntNode d=sentinel;
        while (d.next!=null){
            d=d.next;
            System.out.print(d.item+" ");
        }
    }

    public int get(int num){
        DIntNode di=sentinel;
        for (int i=0;i<num;i++){
            di=di.next;
        }
        return di.item;
    }

    public static void main(String[] args) {
        DLList s=new DLList(4);
        s.addFirst(5);
        s.addFirst(7);
        s.addLast(8);
//        System.out.println(s.getFirst());
        s.print();
//        System.out.println(s.getLast());
//        System.out.println(s.size());
//        System.out.println(s.get(4));
    }
}
