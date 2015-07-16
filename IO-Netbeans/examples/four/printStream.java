/*
PrintStream is high-level class.
PrintStream is byte-stream,PrintWriter is Character Stream.
The PrintStream class provides methods to write data to another stream. 
The PrintStream class automatically flushes the data so there is no need to call flush() method. Moreover, its methods don't throw IOException.
*/
package four;
import java.io.*;
public class printStream {
    public static void main(String str[]) throws IOException
    {
    FileOutputStream fout=new FileOutputStream("F:\\core\\java\\eclipse\\io\\examples\\three\\sai.txt");
    PrintStream psa=System.out;//giving reference to initial value of out i.e output on monitor.
    PrintStream ps=new PrintStream(fout);
    System.setOut(ps);
    System.out.print("kiraak");//writes Kiirak in file,doesnot print kiraak on screen.
   PrintStream ps1=System.out;
    System.setOut(ps1);
    ps1.print(" text");//writes Kiirak in file
   psa.println("on screen");//prints on screen
    PrintStream ps2=psa; //ps2 points to psa i.e initial System.out variable.
    System.setOut(psa);//it could be also done by System.setOut(psa);
    System.out.println("back on screen");//prints on screen.
    
        
    }
}
