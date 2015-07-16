/*


*/
package serialization;

import java.io.Serializable;

class Base implements Serializable//the class that we need to serilize must be implementing Serializable,else ClassNotSerializableException will be thrown.
{
int z;
}
 public class Emp extends Base 
{
    transient int a;//transient variables are not serialized.
    int b;//static variables are also not serialized.
    String name;
   static  int age;
   
    Base b1=new Base();
    Emp(String name,int age,int a,int b,int z)
    {
     
    this.name=name;
    this.age=age;
    this.a=a;
    this.b=b;
    this.z=z;
    }
            
}
