package lcof22_lian_biao_zhong_dao_shu_di_kge_jie_dian;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur1 = head, cur2 = head;
        while (k-- > 0) {
            cur2 = cur2.next;
        }
        while (cur2 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}