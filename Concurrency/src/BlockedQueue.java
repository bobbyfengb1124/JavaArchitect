import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueue {
    ReentrantLock lock;
    Condition condition;

    LinkedList<Integer> queue;

    public BlockedQueue() {
        lock = new ReentrantLock();
        queue = new LinkedList();
        condition = lock.newCondition();
    }

    public static void main(String[] args) {
        BlockedQueue blockedQueue = new BlockedQueue();
        new Thread() {
            public void run() {
                System.out.println("Taking Thread Running");
                Integer ret = blockedQueue.take();
                System.out.println("Taking Thread Finish");
                System.out.println("The element is: " + ret);
            }
        }.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread() {
            public void run() {
                System.out.println("Putting Thread Running");
                blockedQueue.put(3);
                System.out.println("Putting Thread Finish");
            }
        }.start();

    }

    public void put(Integer num) {
        lock.lock();
        queue.addLast(num);
        condition.signal();
        lock.unlock();
    }

    public Integer take() {
        Integer ret;
        lock.lock();
        if (queue.size() == 0) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ret = queue.peekFirst();
        lock.unlock();
        return ret;
    }
}
