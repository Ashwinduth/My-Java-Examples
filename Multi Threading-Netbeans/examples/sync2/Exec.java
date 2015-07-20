/*
 second example of Synchronization with two methods 
 in this example if two threads access two methods of a class through same object,then the access is not in order.to achieve proper order,we use
  synchronization in both methods,else it fails.this is because if other thread enter method before other thread exits,the data is corrupted.
  a class having all sync methods in called synchronized class.in most of the cases,one thread takes a lock,runs show(),returns from it,
  and release lock to other thread.then other thread can now run show().Dont get confused that if thread acquires lock on a object,it
  acquires lock on all the sync menthods and runs them all.this is wrong.the thread acquires lock on a object,but release the lock after 
  running one sync method.now if the lock is acquired by another lock,it runs the method.
  
*/
package sync2;
class Shared
{
	int a,b;
	synchronized public void show(int x)
	//public void show(int x)
	{
		a=x;
     System.out.println(Thread.currentThread().getName()+" Entered in show with "+a+" lock: "+Thread.holdsLock(this));
      try {
    	  Thread.sleep(1000) ;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      System.out.println(Thread.currentThread().getName()+" Exited from show with "+a);
	}
synchronized public void show1(int y)
//	public void show1(int y)
	{
		b=y;
		System.out.println(Thread.currentThread().getName()+" Entered in show1 with "+b+" lock: "+Thread.holdsLock(this));
      try {
    	  Thread.sleep(1000) ;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      System.out.println(Thread.currentThread().getName()+" Exited from show1 "+b);
	}

}
class Thread1 extends Thread
{
	private Shared m; 
     public Thread1(Shared m,String str)
     {
        super(str);
        this.m=m;
        start();
     }
     public void run()
     {
         m.show(1);
     m.show1(1);
         
          
     }

}
class Thread2 extends Thread
{
	private Shared m; 
     public Thread2(Shared m,String str)
     {
        super(str);
        this.m=m;
        start();
     }
     public void run()
     {
        m.show(2);
         m.show1(2);
         
          
     }

}

public class Exec
{
  public static void main(String s[])
  {
	  Shared m=new Shared();
	  Thread1 t=new Thread1(m,"t1");
	  Thread2 t1=new Thread2(m,"t2");
	  //Thread1 t3=new Thread1(m,"t3");
  }
}
