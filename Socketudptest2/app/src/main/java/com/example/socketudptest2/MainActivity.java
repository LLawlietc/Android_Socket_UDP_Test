package com.example.socketudptest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(){
            @Override
            public void run(){
                try {
                //1、创建DatagramSocket用于UDP数据传送。
                DatagramSocket socket = new DatagramSocket();

                //2、创建需要发送的数据包
                byte[] buf = "Hello World,success udp.".getBytes();
                DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("10.0.2.15"), 7879);

                //3、发送
                socket.send(packet);

                //4、关闭连接
                socket.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }}
}.start();

    }
}
