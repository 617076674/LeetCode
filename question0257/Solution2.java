package question0257;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-06-30
 *
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n是树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：2ms，击败99.85%。消耗内存：37.2MB，击败96.43%。
 */
public class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            return list;
        }
        List<String> leftResult = binaryTreePaths(root.left);
        for (String s : leftResult) {
            StringBuilder sb = new StringBuilder(String.valueOf(root.val));
            sb.append("->");
            sb.append(s);
            list.add(sb.toString());
        }
        List<String> rightResult = binaryTreePaths(root.right);
        for (String s : rightResult) {
            StringBuilder sb = new StringBuilder(String.valueOf(root.val));
            sb.append("->");
            sb.append(s);
            list.add(sb.toString());
        }
        return list;
    }
}
