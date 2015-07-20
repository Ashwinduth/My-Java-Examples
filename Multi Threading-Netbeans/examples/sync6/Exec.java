/*
 * In following program the,we use wait and notify inplace of suspend and resume.show4 is synchronized.we can call wait directly as it is method 
 * of object class.when thread encounters wait in a sync method,it goes to blocked pool and returns lock so that other thread can run method.in 
 * following program,first thread enters show4,goes to blocked pool and returrn lock.thus second method is able to enter sync method show4.
 * 
 */
package sync6;

class Shared {

    int x;

    synchronized public void show4(String s, int a) 
    //public void show4(String s, int a)
    {
        x = a;
        System.out.println(" " + s + " entered with x= " + x);
        try {
			wait();//sends Thread to blocked pool
			notify();//doesnot work
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        
        System.out.println(" " + s + " exiting with x= " + x);//this statement is never reached and program hangs
    }
}
class Thread1 extends Thread {

    int a;
    Shared s;
    String str;

    public Thread1(Shared s, String str, int a) {
        super(str);
        this.a = a;
        this.s = s;
        this.str = str;
        start();
    }

    @Override
    public void run() {
        s.show4(str, a);
    }
}

public class Exec {

    public static void main(String sd[]) {
        Shared s = new Shared();
        Thread1 t1 =new Thread1(s, "t1", 10);
       Thread1 t2=new Thread1(s,"t2",20);
    }
}
