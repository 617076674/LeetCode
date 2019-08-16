package question1114;

/**
 * 使用synchronized加锁，并用wait和notifyAll机制来等待和唤醒。
 *
 * 执行用时：18ms，击败91.02%。消耗内存：36MB，击败100.00%。
 */
public class Foo1 {

    public Foo1() {

    }

    private volatile boolean isReadySecond;

    private volatile boolean isReadyThird;

    private Object mutex = new Object();

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (mutex) {
            printFirst.run();
            isReadySecond = true;
            mutex.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (mutex) {
            while (!isReadySecond) {//wait()被notifyAll()唤醒之后，会沿着wait()之后的语句开始执行，所以此处要用while循环
                mutex.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            isReadyThird = true;
            mutex.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (mutex) {
            while (!isReadyThird) { //wait()被notifyAll()唤醒之后，会沿着wait()之后的语句开始执行，所以此处要用while循环
                mutex.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}