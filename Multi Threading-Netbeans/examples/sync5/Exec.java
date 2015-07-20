/*
 * in following program,we use suspend to send current thread to blocked pool.as it goes to blocked pool,next statement i.e resume is not executed.
 * now if show4 is not synchronized first thread enters show4, then goes to blocked pool,then second enters show4,then goes to blocked pool.
 *  if show4 is synchronized first thread enters show4,goes to blocked pool and also attains the lock,and second thread can't enter show4 as it doesnot has the lock .
 */
package sync5;

class Shared {

    int x;

    //synchronized public void show4(String s, int a) 
    public void show4(String s, int a)
    {
        x = a;
        System.out.println(" " + s + " entered with x= " + x);
        Thread.currentThread().suspend();//sends Thread to blocked pool
        Thread.currentThread().resume();// it has no effect
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
