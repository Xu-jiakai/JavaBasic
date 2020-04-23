package edu.socket.udp3;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatRoom {
    public static void main(String[] args) throws SocketException {
        DatagramSocket dsSend=new DatagramSocket();
        DatagramSocket dsreceive=new DatagramSocket(10086);

        SendThread st=new SendThread(dsSend);
        ReceiveThread rt=new ReceiveThread(dsreceive);

        Thread t1=new Thread(st);
        Thread t2=new Thread(rt);

        t1.start();
        t2.start();
    }
}
