/*
 piped streams elp us to create pipes between input and output stream.it is useful when we create threads.that time we use this process.
*/
package six;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class Poutput implements Runnable
{
PipedOutputStream pout;
//PipedWriter poutw; // we can also use PipedWriter
Poutput(PipedOutputStream pout)
{
this.pout=pout;
}
public void run()
{
    System.out.println("enter text containing maximum 5 letters.");
for(int i=1;i<3;i++)
{
        try {
            //poutw.write(new BufferedReader(new InputStreamReader(System.in)).readLine());//as poutw is character stream,we can direclty write String into it by reading through System.in i.e keyboard.
            pout.write(new BufferedReader(new InputStreamReader(System.in)).readLine().getBytes());//as pout is byte streeam,it needs byte.so we doo such converions.
            
            Thread.sleep(500);
        } catch (Exception ex) {
            Logger.getLogger(Poutput.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
}

class Pinput implements Runnable
{
PipedInputStream pin;
Pinput(PipedInputStream pin)
{
this.pin=pin;
}
public void run()
{
for(int i=1;i<10;i++)
{

    try {
        System.out.print((char)pin.read());
    } catch (IOException ex) {
        Logger.getLogger(Pinput.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}

}
public class Pipe {
    public static void main(String ss[])
    {
    PipedOutputStream pout=new PipedOutputStream();
    PipedInputStream pin=new PipedInputStream();

        try {
            pin.connect(pout);
            
        } catch (IOException ex) {
            Logger.getLogger(Pipe.class.getName()).log(Level.SEVERE, null, ex);
        }
     Poutput po=new Poutput(pout);
     Pinput pi=new Pinput(pin);
     
     
     Thread t1=new Thread(po);
     Thread t2=new Thread(pi);
     
     t1.start();
     t2.start();
    
    
    }
    
}
