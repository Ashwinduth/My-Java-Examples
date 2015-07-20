/*
 * in following program,the use of wait and notify is illustrated.here we must call submit before withdraw.here one thread calls submit,other calls 
 * withdraw.if the withdraw thread executes first,it checks the flag,if flag=0,i.e submit have not been called yet and thus that thread waits.then 
 * submit thread runs,calls submit and resumes withdraw thread,which later calls withdraw.if submit thread runs first,then notify in submit 
 * has not effect as no thread is waiting.wait and notify has to placed in sync methods else IllegalMonitorStateException is thrown.
 */
package sync7;
class Shared{
	int flag=0;
	int data;
	synchronized public void submit()
	{
		flag=1;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		data=10;
		System.out.println("Value submitted by"+Thread.currentThread().getName());
		notify();
		
	}
	synchronized int withdraw()
	{
		if(flag==0){
			System.out.println("sending to wait block");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		return data;
	}
	
}
class Thread1 extends Thread
{
	Shared s;
	Thread1(Shared s,String str)
	{
		super(str);
		this.s=s;
		start();
		
		
	}
	public void run()
	{
		System.out.println("Withdrawing "+s.withdraw());
	}
	
}

class Thread2 extends Thread
{
	Shared s;
	Thread2(Shared s,String str)
	{
		super(str);
		this.s=s;
		start();
		
		
	}
	public void run()
	{
		s.submit();
	}
	
}
public class Exec {
public static void main(String ss[])
{
	Shared s=new Shared();
	Thread1 t1=new Thread1(s,"t1");
	
	Thread2 t2=new Thread2(s,"t2");
	
}
}
