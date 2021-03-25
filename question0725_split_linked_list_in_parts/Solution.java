package question0725_split_linked_list_in_parts;

public class Solution {

  public ListNode[] splitListToParts(ListNode root, int k) {
      int len = getLen(root), average = len / k, extra = len % k;
      ListNode[] result = new ListNode[k];
      ListNode pre = root, cur = root;
      for (int i = 0; i < k; i++) {
          int tempLen = average + (i < extra ? 1 : 0);
          if (null == cur) {
              break;
          }
          result[i] = cur;
          for (int j = 0; j < tempLen - 1; j++) {
              pre = pre.next;
              cur = cur.next;
          }
          cur = cur.next;
          pre.next = null;
          pre = cur;
      }
      return result;
  }

  private int getLen(ListNode root) {
      int result = 0;
      ListNode cur = root;
      while (cur != null) {
          cur = cur.next;
          result++;
      }
      return result;
  }

}