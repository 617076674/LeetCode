package question1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {

  private int n;

  public FooBar(int n) {
    this.n = n;
  }

  private ReentrantLock lock = new ReentrantLock();

  private Condition fooCondition = lock.newCondition();

  private Condition barCondition = lock.newCondition();

  public void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      // printFoo.run() outputs "foo". Do not change or remove this line.
      lock.lock();
      try {
        fooCondition.await();
        printFoo.run();
        barCondition.signal();
      } finally {
        lock.unlock();
      }
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      // printBar.run() outputs "bar". Do not change or remove this line.
      lock.lock();
      try {
        barCondition.await();
        printBar.run();
        fooCondition.signal();
      } finally {
        lock.unlock();
      }
    }
  }

}