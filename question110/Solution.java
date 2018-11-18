package question110;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(Math.abs(calculateDepth(root.left) - calculateDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int calculateDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int levelCount = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            int level = queue.size();
            levelCount++;
            while(level > 0) {
                level--;
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return levelCount;
    }
}
