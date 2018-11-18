package question114;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> preOrder;

    public void flatten(TreeNode root) {
        preOrder = new ArrayList<>();
        preOrderTraversal(root);
        TreeNode cur = root;
        for(int i = 0; i < preOrder.size() - 1; i++){
            cur.left = null;
            cur.right = new TreeNode(preOrder.get(i + 1));
            cur = cur.right;
        }
    }

    private void preOrderTraversal(TreeNode root){
        if(null == root){
            return;
        }
        preOrder.add(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
