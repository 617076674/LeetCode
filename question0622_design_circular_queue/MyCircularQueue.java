package question0622_design_circular_queue;

public class MyCircularQueue {

  private int[] queue;

  private int head = -1;

  private int size;

  public MyCircularQueue(int k) {
    queue = new int[k];
  }

  public boolean enQueue(int value) {
    if (size >= queue.length) {
      return false;
    }
    if (size == 0) {
      head = 0;
    }
    size++;
    queue[(head + size - 1) % queue.length] = value;
    return true;
  }

  public boolean deQueue() {
    if (size == 0) {
      return false;
    }
    queue[head] = 0;
    head = (head + 1) % queue.length;
    size--;
    return true;
  }

  public int Front() {
    return size == 0 ? -1 : queue[head];
  }

  public int Rear() {
    return size == 0 ? -1 : queue[(head + size - 1) % queue.length];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean isFull() {
    return size == queue.length;
  }

}