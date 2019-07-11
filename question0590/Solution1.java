package question0590;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-07-11
 *
 * 递归实现。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：3ms，击败91.59%。消耗内存：52.1MB，击败75.52%。
 */
public class Solution1 {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        postOrderTraversal(root);
        return result;
    }

    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        for (Node tmp : node.children) {
            postOrderTraversal(tmp);
        }
        result.add(node.val);
    }
}
