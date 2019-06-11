package question655;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-06-11
 *
 * 首先计算出树的高度，那么我们的二维字符串数组的行数m就是树高，列数n就是2 ^ m - 1。
 *
 * 然后再递归地去填充该二维字符串即可。
 *
 * 递归过程中需要传入4个参数：树的根节点treeNode，待填充区域层号index，待填充区域左索引left，待填充区域右索引right
 *
 * 时间复杂度是O(t)，其中t为二叉树中的节点个数。空间复杂度是O(mn)。
 *
 * 执行用时：2ms，击败100%。内存消耗：36.8MB，击败96.49%。
 */
public class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> printTree(TreeNode root) {
        int m = getHeight(root);
        int n = (int) (Math.pow(2, m) - 1);
        for (int i = 0; i < m; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add("");
            }
            result.add(list);
        }
        putVals(root, 0, 0, n - 1);
        return result;
    }

    private int getHeight(TreeNode treeNode) {
        if (null == treeNode) {
            return 0;
        }
        return Math.max(getHeight(treeNode.left), getHeight(treeNode.right)) + 1;
    }

    private void putVals(TreeNode treeNode, int index, int left, int right) {
        if (null == treeNode) {
            return;
        }
        int mid = left + (right - left) / 2;
        result.get(index).set(mid, String.valueOf(treeNode.val));
        putVals(treeNode.left, index + 1, left, mid - 1);
        putVals(treeNode.right, index + 1, mid + 1, right);
    }

}
