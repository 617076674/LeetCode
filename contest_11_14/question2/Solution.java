package contest_11_14.question2;

public class Solution {

  public ListNode reverseEvenLengthGroups(ListNode head) {
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = head;
    ListNode cur = dummyHead;
    for (int len = 1; ; len++) {
      ListNode tail = cur;
      int i = 0;
      for (; i < len && null != tail.next; i++) {
        tail = tail.next;
      }
      if (i % 2 == 0) {
        if (tail.next == null) {
          cur.next = reverseList(cur.next);
          return dummyHead.next;
        }
        ListNode tailNext = tail.next;
        tail.next = null;
        ListNode curNext = cur.next;
        cur.next = reverseList(cur.next);
        curNext.next = tailNext;
        cur = curNext;
      } else {
        cur = tail;
      }
    }
  }

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(5);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(6);
    ListNode listNode4 = new ListNode(3);
    ListNode listNode5 = new ListNode(9);
    ListNode listNode6 = new ListNode(1);
    ListNode listNode7 = new ListNode(7);
    ListNode listNode8 = new ListNode(3);
    ListNode listNode9 = new ListNode(8);
    ListNode listNode10 = new ListNode(4);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = listNode6;
    listNode6.next = listNode7;
    listNode7.next = listNode8;
    listNode8.next = listNode9;
    listNode9.next = listNode10;

//    ListNode listNode1 = new ListNode(1);
//    ListNode listNode2 = new ListNode(1);
//    ListNode listNode3 = new ListNode(0);
//    ListNode listNode4 = new ListNode(6);
//    listNode1.next = listNode2;
//    listNode2.next = listNode3;
//    listNode3.next = listNode4;

//    ListNode listNode1 = new ListNode(2);
//    ListNode listNode2 = new ListNode(1);
//    listNode1.next = listNode2;

//    ListNode listNode1 = new ListNode(8);

//    ListNode listNode1 = new ListNode(0);
//    ListNode listNode2 = new ListNode(4);
//    ListNode listNode3 = new ListNode(2);
//    ListNode listNode4 = new ListNode(1);
//    ListNode listNode5 = new ListNode(3);
//    listNode1.next = listNode2;
//    listNode2.next = listNode3;
//    listNode3.next = listNode4;
//    listNode4.next = listNode5;
    print(new Solution().reverseEvenLengthGroups(listNode1));
  }

  private static void print(ListNode listNode) {
    StringBuilder sb = new StringBuilder();
    ListNode cur = listNode;
    while (cur != null) {
      sb.append(cur.val).append("->");
      cur = cur.next;
    }
    System.out.println(sb.toString());
  }

  private ListNode reverseList(ListNode listNode) {
    if (null == listNode || listNode.next == null) {
      return listNode;
    }
    ListNode dummyHead = new ListNode(-1);
    dummyHead.next = listNode;
    ListNode cur1 = dummyHead.next, cur2 = cur1.next;
    while (cur2 != null) {
      cur1.next = cur2.next;
      cur2.next = dummyHead.next;
      dummyHead.next = cur2;
      cur2 = cur1.next;
    }
    return dummyHead.next;
  }

}