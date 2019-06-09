package question501;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    private boolean firstNode = true;

    private int pre;

    private int count = 0;

    private int maxCount = 0;

    private List<Integer> list = new ArrayList<>();


    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void inOrderTraversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        inOrderTraversal(treeNode.left);
        if (firstNode) {
            firstNode = false;
            count = 1;
            pre = treeNode.val;
            list.add(treeNode.val);
        } else {
            if (pre == treeNode.val) {
                count++;
            } else {
                count = 1;
                pre = treeNode.val;
            }
        }
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(treeNode.val);
        } else if (count == maxCount) {
            list.add(treeNode.val);
        }
        inOrderTraversal(treeNode.right);
    }

}
