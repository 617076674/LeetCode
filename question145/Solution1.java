package question145;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        postorderTraversal(treeNode.left, list);
        postorderTraversal(treeNode.right, list);
        list.add(treeNode.val);
    }
}

