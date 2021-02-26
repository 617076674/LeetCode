package question1367_linked_list_in_binary_tree;

/**
 * 递归。
 *
 * 时间复杂度是O(nm)，其中n是链表head的节点个数，m是树root的节点个数。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：42.2MB，击败100.00%。
 */
public class Solution {
    private boolean result;

    public boolean isSubPath(ListNode head, TreeNode root) {
        preOrderTraversal(head, root);
        return result;
    }

    private void preOrderTraversal(ListNode head, TreeNode root) {
        if (null == root || result) {
            return;
        }
        if (isSubPathFromRoot(head, root)) {
            result = true;
        }
        preOrderTraversal(head, root.left);
        preOrderTraversal(head, root.right);
    }

    //head能否从root开始匹配
    private boolean isSubPathFromRoot(ListNode head, TreeNode root) {
        if (null == head) {
            return true;
        }
        if (null == root || head.val != root.val) {
            return false;
        }
        return isSubPathFromRoot(head.next, root.left) || isSubPathFromRoot(head.next, root.right);
    }
}