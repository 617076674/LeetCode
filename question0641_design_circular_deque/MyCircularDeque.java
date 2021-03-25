package question0641_design_circular_deque;

public class MyCircularDeque {

  private int[] queue;

  private int head = -1;

  private int size;

  /**
   * Initialize your data structure here. Set the size of the deque to be k.
   */
  public MyCircularDeque(int k) {
    queue = new int[k];
  }

  /**
   * Adds an item at the front of Deque. Return true if the operation is successful.
   */
  public boolean insertFront(int value) {
    if (size == queue.length) {
      return false;
    }
    head = head == -1 ? 0 : (head - 1 + queue.length) % queue.length;
    queue[head] = value;
    size++;
    return true;
  }

  /**
   * Adds an item at the rear of Deque. Return true if the operation is successful.
   */
  public boolean insertLast(int value) {
      if (size == queue.length) {
          return false;
      }
      size++;
      if (head == -1) {
          head = 0;
          queue[head] = value;
          return true;
      }
      int tail = (head + size - 1) % queue.length;
      queue[tail] = value;
      return true;
  }

  /**
   * Deletes an item from the front of Deque. Return true if the operation is successful.
   */
  public boolean deleteFront() {
    if (size == 0) {
        return false;
    }
    size--;
    if (size == 0) {
        head = -1;
    } else {
        head = (head + 1) % queue.length;
    }
    return true;
  }

  /**
   * Deletes an item from the rear of Deque. Return true if the operation is successful.
   */
  public boolean deleteLast() {
    if (size == 0) {
        return false;
    }
    size--;
    if (size == 0) {
        head = -1;
    }
    return true;
  }

  /**
   * Get the front item from the deque.
   */
  public int getFront() {
      return size == 0 ? -1 : queue[head];
  }

  /**
   * Get the last item from the deque.
   */
  public int getRear() {
      return size == 0 ? -1 : queue[(head + size - 1) % queue.length];
  }

  /**
   * Checks whether the circular deque is empty or not.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Checks whether the circular deque is full or not.
   */
  public boolean isFull() {
    return size == queue.length;
  }

}