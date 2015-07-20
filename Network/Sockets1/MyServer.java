/*********************************************
 *      ______________________________       *
 *     //                            \\      * 
 *    //         G.SAIKIRAN           \\     * 
 *   //________________________________\\    *
 *                                           *
 *********************************************
Sockets are endpoints of two way connection.If you want to connect to someone,you need to be connected with their socket.

*/
import java.net.*;
import java.io.*;
class Send extends Thread
{
BufferedWriter bc;
BufferedReader rb;
String dx;
Socket s;
Send(Socket s)
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
dx=rb.readLine();
bc.write(dx+"\n");
bc.flush();
}while(!dx.equals("stop"));
s.close();
}
catch(Exception e){}
}
}
class Recv extends Thread 
{
BufferedReader bb;
Socket s;
Recv(Socket s)
{
this.s=s;
start();
}
public void run() 
{try{
bb=new BufferedReader(new InputStreamReader(s.getInputStream()));
String srx;
while(true){    
srx=bb.readLine();
if(srx.equals("stop"))
break;
System.out.println("Client: "+srx);
}
System.out.println("Client exited");
s.close();
}
catch(Exception e){}
}
}
public class MyServer
{
public static void main(String str[]) throws Exception
{
ServerSocket ss=new ServerSocket(10);//start server in localhost and port #10
System.out.println("Waiting for Client to connect...");
Socket s=ss.accept();//now the accept method waits for client to connect,when client tries to connect,this method returns a socket which gets connected to the client.
System.out.println("client connected | Client's local Port: "+s.getPort());//to show on which port clientsocket exists.
new Recv(s);//thread for recieving messages
new Send(s);//thread for sending messages
/*it's necessary to create two threads for reading and writing from socket simultaneously,but it's not neccessary to make two separate-
   thread for sending and recieving.we can just create one thread for recieving and place the code in run() of send thread in main(),as main
   is also a thread.this is shown in examples of folder sockets2.
*/
}
}