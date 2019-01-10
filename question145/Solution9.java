package question145;

import java.util.ArrayList;
import java.util.List;

public class Solution9 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        TreeNode dummyRoot = new TreeNode(-1);
        dummyRoot.left = root;
        TreeNode cur = dummyRoot;
        while(cur != null) {
            if(cur.left == null) {
                cur = cur.right;
            }else {
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if(pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                }else {
                    pre.right = null;
                    reverseOrder(cur.left, list);
                    cur = cur.right;
                }
            }
        }
        return list;
    }
    private void reverseOrder(TreeNode treeNode, List<Integer> list) {
        int i = list.size();
        while(treeNode != null) {
            list.add(treeNode.val);
            treeNode = treeNode.right;
        }
        int j = list.size() - 1;
        while(i < j) {
            Integer temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
    }
}

