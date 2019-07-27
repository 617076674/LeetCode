package question0971;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-07-27
 *
 * 递归。
 *
 * 时间复杂度是O(n ^ 2)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：2ms，击败69.35%。消耗内存：36.1MB，击败80.65%。
 */
public class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (canflipMatchVoyage(root, voyage, 0, voyage.length - 1)) {
            return result;
        }
        result.clear();
        result.add(-1);
        return result;
    }

    private boolean canflipMatchVoyage(TreeNode root, int[] voyage, int left, int right) {
        if (null == root) {
            if (left > right) {
                return true;
            } else {
                return false;
            }
        }
        if (root.val != voyage[left]) {
            return false;
        }
        if (root.left == null) {
            return canflipMatchVoyage(root.right, voyage, left + 1, right);
        }
        if (root.right == null) {
            return canflipMatchVoyage(root.left, voyage, left + 1, right);
        }
        //尝试将[left, right]范围根据左右子树区分开
        int leftIndex = -1, rightIndex = -1;
        for (int i = left; i <= right; i++) {
            if (root.left.val == voyage[i]) {
                leftIndex = i;
            }
            if (root.right.val == voyage[i]) {
                rightIndex = i;
            }
        }
        //如果左孩子的值或右孩子的值没找到，直接返回false
        if (leftIndex == -1 || rightIndex == -1) {
            return false;
        }
        if (rightIndex != left + 1) {
            return canflipMatchVoyage(root.left, voyage, left + 1, rightIndex - 1)
                    && canflipMatchVoyage(root.right, voyage, rightIndex, right);
        } else {
            //此时右孩子的值为left + 1，说明需要翻转该节点
            result.add(root.val);
            return canflipMatchVoyage(root.right, voyage, left + 1, leftIndex - 1)
                    && canflipMatchVoyage(root.left, voyage, leftIndex, right);
        }
    }
}
