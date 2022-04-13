package question0432_all_oone_data_structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {

  private static class ListNode {

    Set<String> keySet = new HashSet<>();

    int cnt;

    ListNode pre, next;

    public ListNode(int cnt) {
      this.cnt = cnt;
    }

    public void insertAfter(ListNode node) {
      node.next = this.next;
      this.next.pre = node;
      this.next = node;
      node.pre = this;
    }

    public void insertBefore(ListNode node) {
      node.pre = this.pre;
      this.pre.next = node;
      this.pre = node;
      node.next = this;
    }

  }

  private Map<String, ListNode> key2ListNode = new HashMap<>();

  private ListNode dummyHead = new ListNode(Integer.MAX_VALUE);

  private ListNode dummyTail = new ListNode(0);

  public AllOne() {
    dummyHead.next = dummyTail;
    dummyTail.pre = dummyHead;
  }

  public void inc(String key) {
    ListNode curNode = key2ListNode.get(key);
    if (null == curNode) {
      if (dummyTail.pre.cnt == 1) {
        dummyTail.pre.keySet.add(key);
        key2ListNode.put(key, dummyTail.pre);
      } else {
        curNode = new ListNode(1);
        curNode.keySet.add(key);
        key2ListNode.put(key, curNode);
        dummyTail.insertBefore(curNode);
      }
      return;
    }
    curNode.keySet.remove(key);
    ListNode preNode = curNode.pre;
    ListNode nextNode = curNode.next;
    if (curNode.keySet.isEmpty()) {
      preNode.next = nextNode;
      nextNode.pre = preNode;
    }
    int keyCnt = curNode.cnt + 1;
    if (keyCnt == preNode.cnt) {
      preNode.keySet.add(key);
      key2ListNode.put(key, preNode);
    } else {
      // 在 preNode 之后插入一个新的 ListNode
      ListNode newListNode = new ListNode(keyCnt);
      newListNode.keySet.add(key);
      preNode.insertAfter(newListNode);
      key2ListNode.put(key, newListNode);
    }
  }

  public void dec(String key) {
    ListNode curNode = key2ListNode.get(key);
    curNode.keySet.remove(key);
    ListNode preNode = curNode.pre;
    ListNode nextNode = curNode.next;
    if (curNode.keySet.isEmpty()) {
      preNode.next = nextNode;
      nextNode.pre = preNode;
    }
    int keyCnt = curNode.cnt - 1;
    if (keyCnt == 0) {
      key2ListNode.remove(key);
      return;
    }
    if (keyCnt == nextNode.cnt) {
      nextNode.keySet.add(key);
      key2ListNode.put(key, nextNode);
    } else {
      // 在 nextNode 之前插入一个新的 ListNode
      ListNode newListNode = new ListNode(keyCnt);
      newListNode.keySet.add(key);
      nextNode.insertBefore(newListNode);
      key2ListNode.put(key, newListNode);
    }
  }

  public String getMaxKey() {
    ListNode head = dummyHead.next;
    if (head.keySet.isEmpty()) {
      return "";
    }
    return head.keySet.iterator().next();
  }

  public String getMinKey() {
    ListNode tail = dummyTail.pre;
    if (tail.keySet.isEmpty()) {
      return "";
    }
    return tail.keySet.iterator().next();
  }
  
}