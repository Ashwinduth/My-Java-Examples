import java.net.*;
import java.io.*;
//core\java\java\Sockets
class Send1 extends Thread //Thread to send Messages
{
BufferedWriter bc;//to write outgoing message 
BufferedReader rb;//to read from keyboard
String dx;//to store line from keyboard
Socket s;//reference to client socket
Send1(BufferedWriter bc,BufferedReader rb,Socket s)
{
this.bc=bc;
this.rb=rb;
this.s=s;
start();
}
public void run()
{
try{
do{   
dx=rb.readLine();//read from buffer connected to keyboard
bc.write(dx+"\n");//write message to buffer connected to output stream of socket.
bc.flush();//to send complete data from buffer to socket and empty it..it's important
}while(!dx.equals("stop"));//loop till stop is typed
s.close();

}
catch(Exception e){}
}
}
class Recv1 extends Thread //thread to recieve incoming messages.
{
BufferedReader bb;//to read from socket
Socket s;//reference to client socket
Recv1(BufferedReader bb,Socket s)
{
this.bb=bb;
this.s=s;
start();

}
public void run() 
{try{
String srx;
do{    
srx=bb.readLine();//read from buffer connected to input stream of socket
System.out.println("Peer: "+srx);//display message
}
while(!srx.equals("stop"));
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
Socket s=new Socket("192.168.1.4",10);
System.out.println("connected");
BufferedReader bb=new BufferedReader(new InputStreamReader(s.getInputStream()));
BufferedWriter bc=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
BufferedReader rb=new BufferedReader(new InputStreamReader(System.in));
new Recv1(bb,s);
new Send1(bc,rb,s);

}
}