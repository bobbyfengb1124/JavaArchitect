import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueue1 {
    ReentrantLock lock;
    Condition readCondition;
    Condition writeCondition;
    Integer limit;

    LinkedList<Integer> queue;

    public BlockedQueue1(int limit) {
        lock = new ReentrantLock();
        queue = new LinkedList();
        readCondition = lock.newCondition();
        writeCondition = lock.newCondition();
        this.limit = limit;
    }

    public static void main(String[] args) {
        BlockedQueue1 blockedQueue = new BlockedQueue1(1);
        new Thread() {
            public void run() {
                System.out.println("Taking Thread 1 Running");
                Integer ret = blockedQueue.take();
                System.out.println("Taking Thread 1 Finish: " + ret);
            }
        }.start();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread() {
            public void run() {
                System.out.println("Putting Thread 1 Running");
                blockedQueue.put(3);
                System.out.println("Putting Thread 1 Finish");
            }
        }.start();

        new Thread() {
            public void run() {
                System.out.println("Putting Thread 2 Running");
                blockedQueue.put(4);
                System.out.println("Putting Thread 2 Finish");
            }
        }.start();

        new Thread() {
            public void run() {
                System.out.println("Putting Thread 3 Running");
                blockedQueue.put(5);
                System.out.println("Putting Thread 3 Finish");
            }
        }.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread() {
            public void run() {
                System.out.println("Taking Thread 2 Running");
                Integer ret = blockedQueue.take();
                System.out.println("Taking Thread 2 Finish: " + ret);
            }
        }.start();

    }

    public void put(Integer num) {
        lock.lock();
        if (queue.size() >= limit) {
            try {
                writeCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        queue.push(num);

        readCondition.signal();
        lock.unlock();
    }

    public Integer take() {
        Integer ret;
        lock.lock();
        if (queue.size() == 0) {
            try {
                readCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ret = queue.pollFirst();
        writeCondition.signal();
        lock.unlock();
        return ret;
    }
}
