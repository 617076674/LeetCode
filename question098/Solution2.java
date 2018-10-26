package question098;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83338196
 */
import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    List<Integer> list;

    public boolean isValidBST(TreeNode root) {
        list = new ArrayList<>();
        inorderTraversal(root);
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) <= list.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    private void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}
