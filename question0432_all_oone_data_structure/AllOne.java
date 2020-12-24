package question0432_all_oone_data_structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {

  private static class Node {
    int value;
    Node prev;
    Node next;
    Set<String> keys = new HashSet<>();
  }

  private Map<String, Node> map = new HashMap<>();

  private Node head;

  private Node tail;

  /**
   * Initialize your data structure here.
   */
  public AllOne() {

  }

  /**
   * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
   */
  public void inc(String key) {
    Node node = map.get(key);
    if (node == null) {
      if (head == null) {
        head = tail = new Node();
        head.value = 1;
        head.keys.add(key);
      } else if (head.value == 1) {
        head.keys.add(key);
      } else {
        Node newHead = new Node();
        newHead.next = head;
        head.prev = newHead;
        newHead.value = 1;
        newHead.keys.add(key);
        head = newHead;
      }
      map.put(key, head);
    } else {
      if (node == tail) {
        if (node.keys.size() == 1) {
          node.value++;
        } else {
          Node newTail = new Node();
          tail.keys.remove(key);
          newTail.value = node.value + 1;
          newTail.keys.add(key);
          newTail.prev = node;
          node.next = newTail;
          tail = newTail;
        }
        map.put(key, tail);
      } else if (node.next.value == node.value + 1) {
        if (node.keys.size() == 1) {
          node.next.keys.add(key);
          map.put(key, node.next);
          if (node == head) {
            head = node.next;
            node.next.prev = null;
            node.next = null;
          } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
          }
        } else {
          node.keys.remove(key);
          node.next.keys.add(key);
          map.put(key, node.next);
        }
      } else {
        if (node.keys.size() == 1) {
          node.value++;
        } else {
          Node tmp = new Node();
          tmp.value = node.value + 1;
          tmp.keys.add(key);
          tmp.prev = node;
          tmp.next = node.next;
          node.next.prev = tmp;
          node.next = tmp;
          map.put(key, tmp);
        }
      }
    }
  }

  /**
   * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
   */
  public void dec(String key) {
    Node node = map.get(key);
    if (null == node) {
      return;
    }
    if (node.value == 1) {
      map.remove(key);
      if (node.keys.size() == 1) {
        head = node.next;
      } else {
        node.keys.remove(key);
      }
    } else {
      if (node == head) {
        if (node.keys.size() == 1) {
          node.value--;
        } else {
          node.keys.remove(key);
          head = new Node();
          head.value = node.value - 1;
          head.keys.add(key);
          head.next = node;
          node.prev = head;
          map.put(key, head);
        }
      } else if (node.prev.value == node.value - 1) {
        node.prev.keys.add(key);
        map.put(key, node.prev);
        if (node.keys.size() == 1) {
          if (node == tail) {
            tail = node.prev;
            node.prev.next = null;
            node.prev = null;
          } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
          }
        } else {
          node.keys.remove(key);
        }
      } else {
        if (node.keys.size() == 1) {
          node.value--;
        } else {
          Node tmp = new Node();
          tmp.value = node.value - 1;
          tmp.keys.add(key);
          tmp.prev = node.prev;
          tmp.next = node;
          node.prev.next = tmp;
          node.prev = tmp;
          map.put(key, tmp);
        }
      }
    }
  }

  /**
   * Returns one of the keys with maximal value.
   */
  public String getMaxKey() {
    return tail == null ? "" : tail.keys.iterator().next();
  }

  /**
   * Returns one of the keys with Minimal value.
   */
  public String getMinKey() {
    return head == null ? "" : head.keys.iterator().next();
  }

}