package question107;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        if(null == root){
            return listList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int qSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < qSize; i++){
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if(null != treeNode.left){
                    queue.add(treeNode.left);
                }
                if(null != treeNode.right){
                    queue.add(treeNode.right);
                }
            }
            listList.add(list);
        }
        Collections.reverse(listList);
        return listList;
    }
}
