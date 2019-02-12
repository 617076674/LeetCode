package question222;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public int countNodes(TreeNode root) {
        int result = 0;
        if(null == root){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.add(cur);
        while(!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            result++;
            if(null != treeNode.left){
                queue.add(treeNode.left);
            }
            if(null != treeNode.right){
                queue.add(treeNode.right);
            }
        }
        return result;
    }
}
