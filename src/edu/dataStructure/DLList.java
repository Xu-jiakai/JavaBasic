package edu.dataStructure;

public class DLList {
    private int size;
    private DIntNode sentinel;

    public DLList(){
        sentinel=new DIntNode(null,63,null);
        size=0;
    }

    public DLList(int x){
        sentinel=new DIntNode(sentinel,63,sentinel);
        sentinel.next=new DIntNode(sentinel,x,sentinel);
        size=1;
    }

    public void addFirst(int x){
        sentinel.next=new DIntNode(sentinel,x,sentinel.next);
        size+=1;
    }

    public int getFirst(){
        return sentinel.next.item;
    }

    public void addLast(int x){
        sentinel.prev=new DIntNode(sentinel.prev,x,sentinel);
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
        DLList s=new DLList();
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
