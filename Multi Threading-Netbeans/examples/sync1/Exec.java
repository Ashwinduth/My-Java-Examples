/*
First example of synchronization.
In following program thread t1,t2 and t3 access common class-Shared which contain method to add two numbers.but due to absence of synchronization,
the data is corrupted and we donot get the correct answers.if we use Synchronization by rewriting add() as synchronized public run(int a,int b),then we get 
correct output  .
read more at https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
*/

package sync1;

class Shared
{
	int x,y;

	synchronized public int add(int x,int y)
	//public int add(int x,int y)
	{
		
     this.x=x;
     this.y=y;
     System.out.println(" "+Thread.holdsLock(this));
      try {
    	  Thread.sleep(1000) ;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return this.x+this.y;//not x+y
	}

}
class Thread1 extends Thread
{
	Shared m; 
	int x,y;
     public Thread1(Shared m,String str,int a,int b)
     {
        super(str);
        this.m=m;
       x=a;
       y=b;
        start();
     }
     public void run()
     {
          System.out.println("add("+x+","+y+")= "+m.add(x,y)+" from thread "+Thread1.currentThread().getName());
          
     }

}

public class Exec
{
  public static void main(String s[])
  {
	  Shared m=new Shared();
	  Thread1 t=new Thread1(m,"t1",10,20);
	  Thread1 t1=new Thread1(m,"t2",20,30);
	  Thread1 t3=new Thread1(m,"t3",30,40);
  }
}
