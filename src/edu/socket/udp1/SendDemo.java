package edu.socket.udp1;

import java.io.IOException;
import java.net.*;

/*  UDP协议发送数据：
 *     A:创建发送端Socket对象
 *     B:创建数据，并把数据打包
 *     C:调用Socket对象的发送方法发送数据包
 *     D:释放资源
 */
public class SendDemo {
    public static void main(String[] args) throws IOException {
        //创建socket对象
        DatagramSocket ds = new DatagramSocket();

        //创建数据，并把数据打包
        //DatagramPacket(byte[] buf, int length, InetAddress address, int port)
        byte[] bys = "Hello,BWH!".getBytes();//把字符串转换成字符数组
        int length = bys.length;
        InetAddress address = InetAddress.getByName("192.168.24.1");
        int port = 10086; //自拟
        DatagramPacket dp = new DatagramPacket(bys, length, address, port);

        //调用Socket对象的方法发送数据包
        //public void send(DatagramPacket p)
        ds.send(dp);

        //释放资源
        ds.close(); //底层依赖IO流，所以要释放资源
    }
}