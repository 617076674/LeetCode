package question0653;

import java.util.ArrayList;
import java.util.List;

/**
 * 先中序遍历，再左右双指针查找。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为二叉树中的节点个数。
 *
 * 执行用时：11ms，击败57.27%。消耗内存：46.4MB，击败80.08%。
 */
public class Solution1 {
    private List<Integer> inOrder = new ArrayList<>();
    
    public boolean findTarget(TreeNode root, int k) {
        inOrderTraversal(root);
        int left = 0, right = inOrder.size() - 1;
        while (left < right) {
            if (inOrder.get(left) + inOrder.get(right) == k) {
                return true;
            } else if (inOrder.get(left) + inOrder.get(right) < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
    
    private void inOrderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        inOrderTraversal(treeNode.left);
        inOrder.add(treeNode.val);
        inOrderTraversal(treeNode.right);
    }
}