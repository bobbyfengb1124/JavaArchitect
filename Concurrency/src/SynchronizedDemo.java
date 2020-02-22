public class SynchronizedDemo implements Runnable{
    int x = 100;

    public synchronized void m1() {
        x = 1000;
        System.out.println(Thread.currentThread().getId() + " Going to sleep for 1 second.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId() +  " Finish Sleeping.");
        System.out.println("x=" + x);
    }

    public synchronized void m2() {
        System.out.println(Thread.currentThread().getId()+ " going to sleep for 200 ms");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId() +  " Finish Sleeping.");
        x = 2000;
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDemo sd = new SynchronizedDemo();
        new Thread(()->sd.m1()).start(); //13
        new Thread(()->sd.m2()).start();

        System.out.println(Thread.currentThread().getId() + " calling m2 method"); //1
        sd.m2();
        System.out.println("Main x=" + sd.x);
    }
    @Override
    public void run() {
        System.out.println("++++++");
        m1();
    }
}