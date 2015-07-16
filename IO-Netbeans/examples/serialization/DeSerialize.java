package serialization;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DeSerialize {
    ObjectInputStream din;
     public DeSerialize()
     {
        try {
            din= new ObjectInputStream(new FileInputStream("F:\\core\\java\\eclipse\\io\\examples\\serialization\\sai.txt"));
            
            Emp z=(Emp)din.readObject();//retrieveing the state from file.
            //if the Emp was not serialized , above statement would throw Exception,
            System.out.println(z.name);
            System.out.println(z.age);//will show 0
            System.out.println(z.a);//will show 0
            System.out.println(z.b);
            System.out.println(z.z);
            
        } catch (Exception ex) {
            Logger.getLogger(DeSerialize.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
     }
     public static void main(String sf[])
     {
     new DeSerialize();
     }
}
