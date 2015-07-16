/*
*Data streams support binary I/O of primitive data type values (boolean, char, byte, short, int, long, float, and double) as well as String values.
So it is useful to Read and write primitive values from the stream.
This is useful if we want to avoid conversions from string to int or double or float.we can directly write as Int and retrieve back as int without
conversions.We can also use it for UTF strings.Datastreams are generally used to write and read a set of data records,in which different types of data(eg: int,String) are present in
order.

Datastreams are high level classes which are extension of FilterOutputStream(for DataOutputStream) and FilterInputStream(for DataInputStream).

*/
package two;
import java.io.*;
public class dataStream {
public static void main(String st[]) throws IOException
{
FileOutputStream fout=new FileOutputStream("F:\\core\\java\\eclipse\\io\\examples\\two\\sai.txt");
DataOutputStream dout=new DataOutputStream(fout);
dout.writeInt(248);
dout.writeInt(298);
dout.writeChar('S');
fout.close();
dout.close();
FileInputStream fin=new FileInputStream("F:\\core\\java\\eclipse\\io\\examples\\two\\sai.txt");
DataInputStream din=new DataInputStream(fin);
System.out.println(din.readInt());
System.out.println(din.readInt());
System.out.println(din.readChar());
fin.close();
din.close();
}
}
