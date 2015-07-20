/*
 * example four on synchroniztion to show the use of synchronized blocks(SB). SB can be used in palce of Synchronized methods(SM)
 * 
 * In SB,the thread that holds lock can enter,rest are blocked until that thread exits the SB.the thread gets lock on the object passed into SB.
 * in following program,the method dt() is called twice in class Shared.if we want to run dt by in thread at a time then we place dt in SB.we can pass
 * refrence of any object i.e that of Shared (this) or that of temp (t).if we want both dt in show1 and show3 to be sync,then place both in SB.
 * placing both dt in SB is equivalent to making dt as SM.SB is useful to make specific part of method synchronized,not complete method.Sb makes complete
 * method Sync.in this program,we are making the part of calling dt as sync.here the Threads are able to enter show1 or show3 even if one thread is running
 * dt.this is because only dt is inside SB,not other part where we placed System.out.println(s+" inside show1")
 */
package sync4;
class Shared
{
	Temp t;

	{
		t=new Temp();
	}
	void show1(String s)
	{
		System.out.println(s+" inside show1");
		//synchronized(this)
		synchronized(t)
		{
			System.out.println(s+" has the lock "+Thread.currentThread().holdsLock(t));
			t.dt(s,"show1");
		}		
		
	}
	
	void show3(String s)
		{
		System.out.println(s+" inside show3");
		synchronized(t)
		{
	    System.out.println(s+" has a lock "+Thread.currentThread().holdsLock(t));	
		t.dt(s,"show3");
		}
		
        }
}
class Thread1 extends Thread
{
 Shared s;
 Thread1(Shared s,String str){
	super(str);
	this.s=s;
	start();
 }
 public void run()
 {
	 s.show1(currentThread().getName());
	 s.show3(currentThread().getName());
 }
}
class Temp
{
//synchronized void dt(String s,String m)
	void dt(String s,String m)
 {
		System.out.println(" "+s+" in dt from "+m+" -> "+Thread.currentThread().holdsLock(this));
	 for(int y=1;y<3;y++)
		 System.out.println(y+1+" > "+s+" from "+m);
	 try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 for(int y=3;y<=4;y++)
		 System.out.println(y+1+" > "+s+" from "+m);
	 System.out.println("\n");
	  
 }
}
public class Exec {
	public static void main(String st[]){
	Shared s=new Shared();
	Thread1 t1=new Thread1(s,"t 1");
	Thread1 t2=new Thread1(s,"t 2");
	Thread1 t3=new Thread1(s,"t 3");
	}
}
