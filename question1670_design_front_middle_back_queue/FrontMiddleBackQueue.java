package question1670_design_front_middle_back_queue;

import java.util.Deque;
import java.util.LinkedList;

public class FrontMiddleBackQueue {

    private Deque<Integer> list1 = new LinkedList<>();

    private Deque<Integer> list2 = new LinkedList<>();

    public FrontMiddleBackQueue() {

    }
    
    public void pushFront(int val) {
        list1.addFirst(val);
        if (list1.size() == list2.size() + 2) {
            list2.addFirst(list1.pollLast());
        }
    }
    
    public void pushMiddle(int val) {
        if (list1.size() == list2.size() + 1) {
            list2.addFirst(list1.pollLast());
        }
        list1.addLast(val);
    }
    
    public void pushBack(int val) {
        list2.addLast(val);
        if (list2.size() == list1.size() + 1) {
            list1.addLast(list2.pollFirst());
        }
    }
    
    public int popFront() {
        if (list1.isEmpty()) {
            return -1;
        }
        int result = list1.pollFirst();
        if (list1.size() + 1 == list2.size()) {
            list1.addLast(list2.pollFirst());
        }
        return result;
    }
    
    public int popMiddle() {
        if (list1.isEmpty()) {
            return -1;
        }
        int result = list1.pollLast();
        if (list1.size() + 1 == list2.size()) {
            list1.addLast(list2.pollFirst());
        }
        return result;
    }
    
    public int popBack() {
        if (list2.isEmpty()) {
            if (list1.isEmpty()) {
                return -1;
            }
            return list1.pollLast();
        }
        int result = list2.pollLast();
        if (list1.size() == list2.size() + 2) {
            list2.addFirst(list1.pollLast());
        }
        return result;
    }

}