package question0257;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-06-30
 *
 * 回溯法。
 *
 * 时间复杂度是O(n)，其中n是树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：5ms，击败28.57%。消耗内存：36.1MB，击败97.47%。
 */
public class Solution1 {
    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths(root, new StringBuilder());
        return list;
    }

    private void binaryTreePaths(TreeNode root, StringBuilder sb) {
        if (null == root) {
            return;
        }
        sb.append(root.val);
        sb.append("->");
        if (root.left == null && root.right == null) {
            list.add(sb.substring(0, sb.length() - 2));
            return;
        }
        binaryTreePaths(root.left, new StringBuilder(sb));
        binaryTreePaths(root.right, new StringBuilder(sb));
    }
}
