package question1114;

import java.util.concurrent.CountDownLatch;

/**
 * 利用两个CountDownLatch实现。
 *
 * 执行用时：21ms，击败59.61%。消耗内存：35.5MB，击败100.00%。
 */
class Foo2 {

    public Foo2() {
        
    }

    private CountDownLatch countDownLatch1 = new CountDownLatch(1);

    private CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}