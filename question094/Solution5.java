package question094;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82056504
 */
import java.util.ArrayList;
import java.util.List;

public class Solution5 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
        	return list;
        }
        TreeNode cur = root;
        while(cur != null) {
        	if(cur.left == null) {
        		list.add(cur.val);
        		cur = cur.right;
        	}else {
        		TreeNode prev = cur.left;
        		while(prev.right != null && prev.right != cur) {
        			prev = prev.right;
        		}
        		if(prev.right == null) {
        			prev.right = cur;
        			cur = cur.left;
        		}else {
        			prev.right = null;
        			list.add(cur.val);
        			cur = cur.right;
        		}
        	}
        }
        return list;
    }
}
