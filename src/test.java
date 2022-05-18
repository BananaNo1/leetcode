import java.util.concurrent.locks.ReentrantLock;

public class test {

    static ReentrantLock lock = new ReentrantLock();
    static final Object object = new Object();
    static int count = 0;

    public static void method1() {
        new Thread(() -> {
            while (count < 100) {
                synchronized (object) {
                    if ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }

        }, "偶数").start();

        new Thread(() -> {
            while (count < 100) {
                synchronized (object) {
                    if ((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                }
            }
        }, "奇数").start();
    }

    public static void method2() {
        new Thread(() -> {
            while (count < 100) {
                lock.lock();
                try {
                    if ((count & 1) == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "偶数").start();

        new Thread(() -> {
            while (count < 100) {
                lock.lock();
                try {
                    if ((count & 1) == 1) {
                        System.out.println(Thread.currentThread().getName() + ":" + count++);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "奇数").start();
    }

    public static void main(String[] args) {
        method2();
    }

}
