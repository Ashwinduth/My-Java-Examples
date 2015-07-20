/*
 * in this example,a method of another class temp is called twice inside the methods of Shared class.to avoid data corruption,we need not make show1 
 * synchronized,we can make dt() synchronized.Here the thread achieves lock on temp object,not Shared.This ensures that all other threads are blocked
 * while one thread is executing the method dt().
 */
package sync12;
class Shared
{
	Temp t;

	{
		t=new Temp();
	}
	void show1(String s)
	{
		
		
			t.dt(s);
				
		
	}
	
	void show3(String s)
		{
		t.dt(s);
		
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
//synchronized void dt(String s)
void dt(String s)
 {
	 for(int y=0;y<5;y++)
		 System.out.println(y+1+" > "+s);
	 try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 for(int y=5;y<8;y++)
		 System.out.println(y+1+" > "+s);
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
