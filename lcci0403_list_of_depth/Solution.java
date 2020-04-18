package lcci0403_list_of_depth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：1ms，击败98.68%。消耗内存：37.9MB，击败100.00%。
 */
public class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (null == tree) {
            return new ListNode[0];
        }
        List<ListNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            ListNode dummyHead = new ListNode(-1), cur = dummyHead;
            for (int i = 0; i < qSize; i++) {
                TreeNode now = queue.poll();
                cur.next = new ListNode(now.val);
                cur = cur.next;
                if (null != now.left) {
                    queue.add(now.left);
                }
                if (null != now.right) {
                    queue.add(now.right);
                }
            }
            list.add(dummyHead.next);
        }
        ListNode[] result = new ListNode[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}