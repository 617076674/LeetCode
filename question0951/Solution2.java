package question0951;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-07-15
 *
 * 伪前序遍历，每次先遍历空孩子节点或节点值较小的孩子节点。
 *
 * 时间复杂度和空间复杂度均是O(n1 + n2)，其中n1为树root1中的节点数量，n2位树root2中的节点数量。
 *
 * 执行用时：3ms，击败94.40%。消耗内存：35.4MB，击败83.33%。
 */
public class Solution2 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList(), list2 = new ArrayList();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.left == null) {
            dfs(node.right, list);
        } else {
            if (node.right == null) {
                dfs(node.left, list);
            } else {
                if (node.left.val < node.right.val) {
                    dfs(node.left, list);
                    dfs(node.right, list);
                } else {
                    dfs(node.right, list);
                    dfs(node.left, list);
                }
            }
        }
    }
}
