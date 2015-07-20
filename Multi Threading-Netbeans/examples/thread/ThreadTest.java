package thread;

class Thread1 extends Thread {
 int d;
 {
	 d=0;
 }
	public Thread1(String s)
	{
		super(s);
		start();
	}
	public void run()
	{
		for (int i=0;i<5;i++)
		{
			d++;
			System.out.println(Thread.currentThread().getName());
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class Thread2 extends Thread {
	 
	public Thread2(String s)
	{
		super(s);
		start();
	}
	public void run()
	{
		for (int i=0;i<7;i++)
		{
			System.out.println(Thread.currentThread().getName());
			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class Thread3 extends Thread {
	Thread1 t;
	public Thread3(String s,Thread1 t)
	{
		super(s);
		this.t=t;
		start();
	}
	public void run()

	{
		for (int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName());
			tell();
			try {
				this.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void tell()
	{
		System.out.println(t.getName()+" is "+t.isAlive()+" "+t.d);
	}
}
public class ThreadTest  {
	
	
	public static void main(String s[])
	{
	Thread1 t1=new Thread1("t1");
	Thread2 t2=new Thread2("t2");
	
	Thread3 t3=new Thread3("t3",t1);
	
    }

}

