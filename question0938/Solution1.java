package question0938;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-07-11
 *
 * 先得到中序遍历结果，再利用floor()和ceil()函数求数组下标的边界。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为树中的节点个数。
 *
 * 执行用时：12ms，击败13.46%。消耗内存：49.9MB，击败70.73%。
 */
public class Solution1 {
    private List<Integer> inOrder = new ArrayList<>();

    public int rangeSumBST(TreeNode root, int L, int R) {
        inOrderTraversal(root);
        int start = ceil(L), end = floor(R), result = 0;
        for (int i = start; i <= end; i++) {
            result += inOrder.get(i);
        }
        return result;
    }

    private void inOrderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        inOrderTraversal(treeNode.left);
        inOrder.add(treeNode.val);
        inOrderTraversal(treeNode.right);
    }

    private int floor(int target) {
        int left = -1, right = inOrder.size() - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (inOrder.get(mid) < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (left + 1 < inOrder.size() && inOrder.get(left + 1) == target) {
            return left + 1;
        }
        return left;
    }

    private int ceil(int target) {
        int left = 0, right = inOrder.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (inOrder.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left - 1 >= 0 && inOrder.get(left - 1) == target) {
            return left - 1;
        }
        return left;
    }
}
