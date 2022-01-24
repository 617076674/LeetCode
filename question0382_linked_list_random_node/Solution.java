package question0382_linked_list_random_node;

import java.util.Random;

/**
 * 蓄水池采样原理：选择第i个节点的概率是1/i。
 *
 * 证明：
 *
 * 选取第n - 1个节点的概率是1 / (n - 1)，其中n是链表中的节点个数，从0开始计数。最终结果是第n - 1个节点值的概率就是1 / (n - 1)。
 *
 * 选取第n - 2个节点的该类是1 / (n - 2)。最终结果是第n - 2个节点值的概率计算如下：
 *
 * P(最终结果是第n - 2个节点值) = P(选取第n - 2个节点且不选择第n - 1个节点)
 * = (1 / (n - 2)) * (1 - 1 / (n - 1)) = 1 / (n - 1) = P(最终结果是第n - 1个节点值)。
 *
 * 以此类推，可知最终结果的选择对所有节点均是公平的。
 *
 * 时间复杂度是O(n)。空间复杂度是O(1)。
 */
public class Solution {

    private ListNode head;

    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        int result = 0, i = 1;
        Random random = new Random();
        while (null != cur) {
            if (random.nextInt(i) == 0) {
                result = cur.val;
            }
            i++;
            cur = cur.next;
        }
        return result;
    }

}