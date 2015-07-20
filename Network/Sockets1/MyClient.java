/*********************************************
 *      ______________________________       *
 *     //                            \\      * 
 *    //         G.SAIKIRAN           \\     * 
 *   //________________________________\\    *
 *                                           *
 *********************************************
 */
import java.net.*;
import java.io.*;
class Send1 extends Thread //Thread to send Messages
{
BufferedWriter bc;//to write outgoing message 
BufferedReader rb;//to read from keyboard
String dx;//to store line from keyboard
Socket s;//reference to client socket
Send1(Socket s)
{

this.s=s;
start();
}
public void run()
{
try{
bc=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
rb=new BufferedReader(new InputStreamReader(System.in));
do{   
dx=rb.readLine();//read from buffer connected to keyboard
bc.write(dx+"\n");//write message to buffer connected to output stream of socket
//we need to put \n as server will read till it recieves \n i.e we press enter.but when we press enter, \n is not passes and flush removes it.so we 
//need to put \n explicitily.to avoid this use DataOutputstream or printwriter.by using printwriter in autoflush mode,we can skip writing below code.
bc.flush();//to send complete data from buffer to socket and empty it,we use flush..it's important.
}while(!dx.equals("stop"));//loop till stop is typed
s.close();//close socket connection

}
catch(Exception e){}
}
}
class Recv1 extends Thread //thread to recieve incoming messages.
{
BufferedReader bb;//to read from socket
Socket s;//reference to socket created by server 
Recv1(Socket s)
{
this.s=s;
start();
}
public void run() 
{try{
bb=new BufferedReader(new InputStreamReader(s.getInputStream()));//input from server's socket
String srx;
while(true){    
srx=bb.readLine();//read from buffer connected to input stream of server's socket
if(srx.equals("stop"))
break;
System.out.println("Server: "+srx);//display message
}
System.out.println("Server exited");
s.close();//close connection
}
catch(Exception e){}
}
}
public class MyClient
{
    
public static void main(String str[])throws Exception
{
Socket s=new Socket("Localhost",10);//connect to server listening at port 10 in locahost
//A socket is created at a port # assigned by system which is displayed below
System.out.println("connected through localPost: "+s.getLocalPort());

new Recv1(s);
new Send1(s);

}
}
/*
why we used flush()?
the buffer of socket is very big and the data is not sent unless it is full.so we use bc.flush(),we dont have to wait 
till buffer gets full,and we can send data each time we write into socket. a answer in  Stackoverflow says:
There's a certain amount of overhead involved in writing to a network socket and sending data. 
If data were sent every time byte entered the socket, you'd end up with 40+ bytes of TCP header for every byte of actual data.
 (Assuming you're using a TCP socket, of course. Other sockets will have different values). 
 In order to avoid such inefficiency, the socket maintains a local buffer, which is usually somewhat over 1000 bytes. 
 When that buffer is filled, a header is wrapped around the data and the packet is sent off to its destination.
*/