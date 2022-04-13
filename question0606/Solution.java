package question0606;

public class Solution {

  public String tree2str(TreeNode root) {
    String result = dfs(root);
    if (result.length() > 0) {
      result = result.substring(1, result.length() - 1);
    }
    return result;
  }

  private String dfs(TreeNode cur) {
    if (null == cur) {
      return "";
    }
    if (cur.left == null && cur.right != null) {
      return "(" + cur.val + "()" + dfs(cur.right) + ")";
    }
    return "(" + cur.val + dfs(cur.left) + dfs(cur.right) + ")";
  }

}
