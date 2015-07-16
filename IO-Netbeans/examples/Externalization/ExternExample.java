/*
In Serialization,the value of all the variables of the object except transient and static variables were saved.
But Through Externalization,we can save the state of only those variables which we want.the variables whose state we we want to change is mentioned 
in writeExternal() method.the state is retrieved by readExternal method.
we need to put both methods i.e writeExternal() and readExternal()in the class that we want to Externalize.
the JVM internally executes writExternal when we Externalize and it executes readExternal when we deExternalize it.
*/

package Externalization;
import java.io.*;
class Car implements Externalizable
{
    int age;
    String name;
    int year;
    //mandatory public no-arg constructor
    public Car()
    {
    System.out.println("default");
    }
    Car(String n,int y)
    {
    
    name=n;
    year=y;
    age=10;
    }
    //mandatory write External method
    public void writeExternal(ObjectOutput out) throws IOException
    {
    out.writeObject(name);
    
    out.writeInt(year);
    out.writeInt(age);
    System.out.println("Writing");
    }
    //mandatory write readExternal method    
    public void readExternal(ObjectInput in) 
    {
        try{
        name=(String)in.readObject();
        year=in.readInt();
        age=in.readInt();
        System.out.println("reading");
        }catch(Exception e){e.printStackTrace();}
    }
    public String toString()
    {
        return("\nName: "+name+"\nyear: "+year+"\nage: "+age);
    }
       
}

public class ExternExample{
public static void main(String s[]) throws Exception
{
//create a new Car object
    System.out.println("proceeding to exernalizing");
    Car car=new Car("sai",1200);
     Car newCar=null;
     //Serialize the car
     FileOutputStream fo=new FileOutputStream("F:\\core\\java\\eclipse\\io\\examples\\Externalization\\temp");
     ObjectOutputStream so=new ObjectOutputStream(fo);
     so.writeObject(car);
     so.flush();
     System.out.println("proceeding to de-exernalizing");
     //deserialize the car
     FileInputStream fi=new FileInputStream("F:\\core\\java\\eclipse\\io\\examples\\Externalization\\temp");
     ObjectInputStream si=new ObjectInputStream(fi);
     newCar=(Car)si.readObject();
     System.out.println("Original Car is: "+car);
     System.out.println("new Car is: "+newCar);
   
     
}
}
