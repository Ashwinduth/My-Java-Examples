/*
Buffered classes are high level classes.Buffered classes provide us the way to connect streams to the buffer created in RAM by OS.now the Streams donot access
the data from files,network directly,they use the buffers which improves the speed and performance.
 */
package three;
import java.io.*;
public class BuffDemo {
    public static void main(String s[]) throws Exception
    {
    //character streams
      
    FileWriter fout=new FileWriter("F:\\core\\java\\eclipse\\io\\examples\\three\\sai.txt");
    BufferedWriter buf=new BufferedWriter(fout);
    buf.write(" writing from buffered stream\n");
    buf.write(" writing again from buffered stream");
    
    buf.close();//if we close buf before closing fout,Exception occurs,as the o/p from fout is connected to buf and should not be closed before fout.
    fout.close();
    BufferedReader a=new BufferedReader(new FileReader("F:\\core\\java\\eclipse\\io\\examples\\three\\sai.txt"));//here we are making unbuffered Stream as buffered stream
    System.out.print(a.readLine());//reads a line.A line is terminated by \n or \r. readline returns line as a string with no \n or \r.
    System.out.print(a.readLine());
    
    //above statements print all two lines in single line as readline doesnot holds \n or \r in end  of line.
   
    a.close();
    System.out.println();
    System.out.println();
    //Byte streams
    BufferedInputStream ab=new BufferedInputStream(new FileInputStream("F:\\core\\java\\eclipse\\io\\examples\\three\\sai.txt"));
    //buffered byte stream does not have readLine() method.
    int c;
    while((c=ab.read())!=-1)
    System.out.print((char)c);
    ab.close();
    System.out.println();
    System.out.println();
    BufferedInputStream b=new BufferedInputStream(new DataInputStream(new FileInputStream("F:\\core\\java\\eclipse\\io\\examples\\three\\sai.txt")));
    byte bt[]=new byte[50];
    b.read(bt);
    System.out.print(new String(bt));
    b.close();
    
    }
}
