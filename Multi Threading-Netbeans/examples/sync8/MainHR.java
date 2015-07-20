/*
 *in Reentrant locking,we can provide the lock to particular thread by lock().now if other thread encounters lock(),they dont get lock until
 *the thread release lock by unlock().till then that thread(which dont have lock) becomes blocked untill it gets the lock.thus whatever lies in
 *between lock and unlock section ,it can be executed only by one thread at a time.
 */
 
package sync8;
import java.util.concurrent.locks.ReentrantLock;
class TechLead1 extends Thread
{
	ReentrantLock qPaper;
	String name;
	TechLead1(ReentrantLock qPaper,String str)
	{
		super(str);
		this.qPaper=qPaper;
		
	}
	public void run()
	{
		System.out.println(getName()+" is Waiting for question paper ");
		qPaper.lock();
		
		System.out.println(getName()+" starts taking test");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getName()+" has completed test");
	   qPaper.unlock();
		
	}
}
class TechLead2 extends Thread
{
	ReentrantLock qPaper;
	String name;
	TechLead2(ReentrantLock qPaper,String str)
	{
		super(str);
		this.qPaper=qPaper;
		
	}
	public void run()
	{
		System.out.println(getName()+" is Waiting for question paper ");
		qPaper.lock();
		
		System.out.println(getName()+" starts taking test");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getName()+" has completed test");
	   qPaper.unlock();
		
	}
}
class TechLead3 extends Thread
{
	ReentrantLock qPaper;
	String name;
	TechLead3(ReentrantLock qPaper,String str)
	{
		super(str);
		this.qPaper=qPaper;
		
	}
	public void run()
	{
		System.out.println(getName()+" is Waiting for question paper ");
		qPaper.lock();
		System.out.println(getName()+" starts taking test");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(getName()+" has completed test");
	   qPaper.unlock();
		
	}
}
class MainHR
{
public static void main(String ss[])
{
	ReentrantLock qPaper=new ReentrantLock();
	new TechLead1(qPaper,"arun").start();
	new TechLead2(qPaper,"karan").start();
	new TechLead3(qPaper,"rahul").start();
	System.out.println("HR completes his work of asking Techleads to take exams");
	
}
}
