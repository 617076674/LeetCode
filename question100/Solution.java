package question100;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83419850
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null && q != null){
            return false;
        }else if(p != null && q == null){
            return false;
        }else{
            if(p.val != q.val){
                return false;
            }else{
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }
}
