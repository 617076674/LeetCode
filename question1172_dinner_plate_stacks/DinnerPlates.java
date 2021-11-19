package question1172_dinner_plate_stacks;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class DinnerPlates {

  private Queue<Integer> canPutQueue = new PriorityQueue<>();

  private Set<Integer> full = new HashSet<>();

  private LinkedList<Integer>[] lists = new LinkedList[200000];

  private int capacity;

  private Queue<Integer> canGetQueue = new PriorityQueue<>((num1, num2) -> num2 - num1);

  public DinnerPlates(int capacity) {
    for (int i = 0; i < 200000; i++) {
      canPutQueue.add(i);
    }
    this.capacity = capacity;
  }

  public void push(int val) {
    while (!canPutQueue.isEmpty()) {
      int index = canPutQueue.poll();
      if (lists[index] == null) {
        lists[index] = new LinkedList<>();
      }
      if (!full.contains(index)) {
        lists[index].add(val);
        if (lists[index].size() == capacity) {
          full.add(index);
        } else {
          canPutQueue.add(index);
        }
        canGetQueue.add(index);
        return;
      }
    }
  }

  public int pop() {
    while (!canGetQueue.isEmpty()) {
      int index = canGetQueue.poll();
      if (lists[index] != null && !lists[index].isEmpty()) {
        canPutQueue.add(index);
        full.remove(index);
        return lists[index].pollLast();
      }
    }
    return -1;
  }

  public int popAtStack(int index) {
    if (lists[index] == null || lists[index].isEmpty()) {
      return -1;
    }
    full.remove(index);
    canPutQueue.add(index);
    return lists[index].pollLast();
  }

}