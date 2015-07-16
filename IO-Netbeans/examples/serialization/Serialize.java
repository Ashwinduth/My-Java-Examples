/*
Serialization in Java is a process used to convert Object into a binary format which can be stored/persisted in disc or sent over network.
the reverse process of creating object from binary stream is called deserialization
transient and static variables can't be serialized.
static variables are'nt serialized because static variables belong to the class are not the part of the state of the object so they are not saved as the part of serialized object.
*/
package serialization;
import java.io.*;

class Serialize 
{
    ObjectOutputStream dout;
 Serialize(){

try{
Emp e1=new Emp("sai",10,5,20,100);//making object of Emp
dout=new ObjectOutputStream(new FileOutputStream("F:\\core\\java\\eclipse\\io\\examples\\serialization\\sai.txt"));
dout.writeObject(e1);//writing state of emp into file
dout.flush();
}
catch(Exception e){}

}
public static void main(String s[])
{
new Serialize();
}
}