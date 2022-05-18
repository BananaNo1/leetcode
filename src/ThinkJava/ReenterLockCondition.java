package ThinkJava;

import sun.misc.Unsafe;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockCondition implements Runnable {

    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static Condition condition = reentrantLock.newCondition();

    @Override
    public void run() {
        try {
            reentrantLock.lock();
            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition t1 = new ReenterLockCondition();
        Thread t = new Thread(t1);
        t.start();
        Thread.sleep(2000);
        reentrantLock.lock();
        condition.signal();
        reentrantLock.unlock();
    }
}
