package lcof52_liang_ge_lian_biao_de_di_yi_ge_gong_gong_jie_dian;

/**
 * 双指针。
 *
 * 时间复杂度是 O(m + n)，其中 m 为链表 headA 的长度，n 为链表 headB 的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：40.9MB，击败98.98%。
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode cur1 = headA, cur2 = headB;
    while (cur1 != cur2) {
      if (cur1 == null) {
        cur1 = headB;
      } else {
        cur1 = cur1.next;
      }
      if (cur2 == null) {
        cur2 = headA;
      } else {
        cur2 = cur2.next;
      }
    }
    return cur1;
  }
}