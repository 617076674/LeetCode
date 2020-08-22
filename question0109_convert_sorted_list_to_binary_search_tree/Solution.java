package question0109_convert_sorted_list_to_binary_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为链表 head 中的节点个数。
 *
 * 执行用时：2ms，击败21.77%。消耗内存：40.8MB，击败73.39%。
 */
public class Solution {
    private List<Integer> list = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {
        ListNode cur = head;
        while (!Objects.isNull(cur)) {
            list.add(cur.val);
            cur = cur.next;
        }
        return sortedArrayToBST(0, list.size() - 1);
    }

    private TreeNode sortedArrayToBST(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + ((right - left) >> 1);
        TreeNode treeNode = new TreeNode(list.get(mid));
        treeNode.left = sortedArrayToBST(left, mid - 1);
        treeNode.right = sortedArrayToBST(mid + 1, right);
        return treeNode;
    }
}