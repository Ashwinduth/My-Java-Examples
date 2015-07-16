/*
 BufferednputStreams are byte streams and BufferedReaders are characters streams
 */
package five;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KBInput {
public static void main(String s[]) throws IOException
{
    FileInputStream fin=new FileInputStream("F:\\core\\java\\eclipse\\io\\examples\\five\\sai.txt");
    BufferedInputStream buf1=new BufferedInputStream(fin);//connecting the buffer to fin.data from fin will be saved in buf1.
    byte a[]=new byte[30];
    buf1.read(a);//read data from buffer into a.
    String str=new String(a);//convert byte array to string.
    System.out.println(str);//prints on screen.
    buf1.close();
    fin.close();
    
    buf1=new BufferedInputStream(System.in);//buf1 now points to new buffer.this new buffer takes input from InputStream object "in" defined in System class.
    //initially System.in has reference of standard input i.e keyboard.so it would take input from keyboard and save it in buffer.
    a=new byte[10];
    System.out.print("type text: ");
    buf1.read(a);//read from keyboard until we hit enter.
    str=new String(a);
    System.out.println(str);
    
    //using Chracter streams
    //System.in is of type inputStream i.e byte stream.
    BufferedReader buf2=new BufferedReader(new InputStreamReader(System.in));//BufferedReader is character stream,so we have to convert byte stream i.e System.in to character stream by InputStreamReader
    System.out.print("type text again: ");
    System.out.println(buf2.readLine());//as BufferedSteams is Chracter streams,we have readline method for it.
    buf1.close();
    buf2.close();//close buffers.
    
    fin=new FileInputStream("F:\\core\\java\\eclipse\\io\\examples\\five\\sai.txt");
    System.setIn(fin);//now we make System.in refer to fin i.e make given file as standard input.
    buf1=new BufferedInputStream(System.in);//connect buf1 to fin.
    a=new byte[30];
    buf1.read(a);
    str=new String(a);
    System.out.println(str);//prints data from file,not from keyboard.
    buf1.close();
    fin.close();
    
    /*
    FileInputStream fin=new FileInputStream("F:\\core\\java\\eclipse\\io\\examples\\five\\sai.txt");
        System.setIn(fin);
        BufferedInputStream buf=new BufferedInputStream(System.in);
        buf.read(a);
        String str=new String(a);
        System.out.println(str);
    */

}
}
