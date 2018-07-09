package com.example.socketudptest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText show = (EditText)findViewById(R.id.edittext);
       try{ //1、创建DatagramSocket;
        DatagramSocket socket = new DatagramSocket(7879);

        //2、创建数据包，用于接收内容。
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);

        //3、接收数据
        socket.receive(packet);
        System.out.println(packet.getAddress().getHostAddress()+":"+packet.getPort());
        //System.out.println(packet.getData().toString());
        //以上语句打印信息错误，因为getData()返回byte[]类型数据，直接toString会将之序列化，而不是提取字符。应该使用以下方法：
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
           String s = new String(packet.getData(), 0, packet.getLength());
           show.setText(s);

        //4、关闭连接。
        socket.close();}
       catch(Exception e){
           e.printStackTrace();
       }
    }
}
