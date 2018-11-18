package question112;

public class Solution2 {
    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if(null == root){
            return flag;
        }
        dfs(root, sum);
        return flag;
    }

    private void dfs(TreeNode root, int sum) {
        if(null == root.left && null == root.right){
            sum -= root.val;
            if(sum == 0){
                flag = true;
            }
            return;
        }
        if(null != root.left){
            dfs(root.left, sum - root.val);
        }
        if(null != root.right){
            dfs(root.right, sum - root.val);
        }
    }
}
