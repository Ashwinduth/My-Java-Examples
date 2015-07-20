/*
third example of synchronization-static methods
In following program thread t1,t2 and t3 access common class-Shared which contain method to add two numbers.the add method is static,hence we can
call it directly without creating the object of its class.but the data is still corrupted if method not synced.thus we need to use synchronization
on static methods also.static synchronized methods acquires the lock on monitor associated with class,
 and non-static synchronized method acquires lock on monitor associated with instance(object).
 
 Java Thread acquires an object level lock when it enters into an instance synchronized java- 
 method and acquires a class level lock when it enters into static synchronized java method.
*/

package sync3;

class Shared
{
	static int x,y;

	synchronized public static int add(int a,int b)
//	public static int add(int a,int b)
	{
		
     x=a;
     y =b;
      try {
    	  Thread.sleep(1000) ;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return x+y;
	}
	synchronized public static int add1(int a,int b)
	//public static int add1(int a,int b)
	{
		
     x=a;
     y =b;
      try {
    	  Thread.sleep(1000) ;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return x+y;
	}

}
class Thread1 extends Thread
{
	
	int x,y;
     public Thread1(String str,int a,int b)
     {
        super(str);
       // this.m=m;
       x=a;
       y=b;
        start();
     }
     public void run()
     {
          System.out.println("add("+x+","+y+")= "+Shared.add(x,y)+" from thread "+Thread1.currentThread().getName());
          System.out.println("add1("+x+","+y+")= "+Shared.add1(x,y)+" from thread "+Thread1.currentThread().getName());
     }

}

public class Exec
{
  public static void main(String s[])
  {
	  //Shared m=new Shared();
	  Thread1 t=new Thread1("t1",10,20);
	  Thread1 t1=new Thread1("t2",20,30);
	  Thread1 t3=new Thread1("t3",30,40);
  }
}
