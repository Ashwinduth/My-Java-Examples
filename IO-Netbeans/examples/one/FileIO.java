/*
FileInputStream and FileOutputStream are byte stream classes.they are low-level classes that can be used to read and write individual, 8-bit bytes 
from a stream .FileInputStream Extends class InputStream and FileOutputStream Extends class OutputStream.
FileReader and FileWriter are character stream classes that extends InputStreamReader and OutputStreamWriter respectively.
n following example,both byte stream and c aare used to read a file.in each case,two ways of reading is depicted.

*/
package one;
import java.io.*;
public class FileIO {   
    public static final String path="F:\\core\\java\\eclipse\\io\\examples\\one\\sai.txt";
public static void main(String str[]) throws IOException{
    FileOutputStream foutA=new FileOutputStream(path);
    byte b[]="sai is a cool boy".getBytes();//we need to convert string into byte as FileOutputStream can write only bytes.
    foutA.write(b);
   foutA.close();//if we dont close,FileWriter object can't write into it.
    FileInputStream finA=new FileInputStream(path);//Byte-Stream
    FileInputStream finB=new FileInputStream(path);//Byte-Stream
    byte bt[]=new byte[100];
    finA.read(bt);//here Byte array is passed into read().if we want to read character by character by this array,we need to convert as (char)bt[0]
    //we can pass only byte array as it is byte stream.
   System.out.println(new String(bt));
   System.out.println();
   finA.close();
   
   int s;
   while((s=finB.read())!=-1)
      System.out.print((char)s);
   finB.close();
   System.out.println();
   System.out.println();
   FileWriter fout1=new FileWriter(path,true);//by writing true,we donot overwrite file,we append it.
   fout1.write(" appending the file");//as FileWriter is character class,we can directly write Strings.
   //below commented code can also write into file.
   //char cx[]="file is appended".toCharArray();//to convert sting to char array;
   //fout1.write(cx);
   
   fout1.close();
   FileReader fin1=new FileReader(path);//Character-Stream
   FileReader fin2=new FileReader(path);//Character-Stream
   char ch[]=new char[100];
    fin1.read(ch);//in character stream,we can pass char array,thus we can read without need of converions.
    System.out.println(new String(ch));
    fin1.close();
   System.out.println();
    int c;
   while((c=fin2.read())!=-1)
      System.out.print((char)c);
   fin2.close();
}
}
