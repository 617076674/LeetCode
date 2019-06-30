package question0257;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @author qianyihui
 * @date 2019-06-30
 *
 * 用栈实现。
 *
 * 时间复杂度是O(n)，其中n是树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：4ms，击败60.40%。消耗内存：36.5MB，击败97.17%。
 */
public class Solution3 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Stack<Pair<TreeNode, String>> stack = new Stack<>();
        stack.push(new Pair<>(root, String.valueOf(root.val)));
        while (!stack.isEmpty()) {
            Pair<TreeNode, String> pair = stack.pop();
            TreeNode treeNode = pair.getKey();
            String s = pair.getValue();
            if (treeNode.left == null && treeNode.right == null) {
                list.add(s);
            }
            if (treeNode.left != null) {
                stack.push(new Pair<>(treeNode.left, s + "->" + treeNode.left.val));
            }
            if (treeNode.right != null) {
                stack.push(new Pair<>(treeNode.right, s + "->" + treeNode.right.val));
            }
        }
        return list;
    }
}
