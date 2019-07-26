package question0598;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-07-26
 *
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h是树的高度。
 *
 * 执行用时：3ms，击败88.47%。消耗内存：53.2MB，击败72.46%。
 */
public class Solution1 {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        preOrderTraversal(root);
        return result;
    }

    private void preOrderTraversal(Node node) {
        if (null == node) {
            return;
        }
        result.add(node.val);
        for (Node tmp : node.children) {
            preOrderTraversal(tmp);
        }
    }
}
