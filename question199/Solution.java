package question199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(null == root){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(null != cur.left){
                    queue.add(cur.left);
                }
                if(null != cur.right){
                    queue.add(cur.right);
                }
            }
            result.add(list.get(list.size() - 1));
        }
        return result;
    }
}
