package lcp34_er_cha_shu_ran_se_UGC;

/**
 * 后序遍历
 */
public class Solution {

  public int maxValue(TreeNode root, int k) {
    int[] dp = postOrderTraversal(root, k);
    int max = Integer.MIN_VALUE;
    for (int i = 0; i <= k; i++) {
      //取root的各种染色情况的最大值
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  /**
   * 当前根结点是 root，最多仅有 k 个节点可连续染色。
   * 返回结果是一个数组，dp[i] 表示根结点 root 处的连续节点数为 i
   */
  private int[] postOrderTraversal(TreeNode root, int k) {
    int[] dp = new int[k + 1];
    //1.初始化：空节点为底，自底向上
    if (root == null) {
      return dp;
    }
    //2.获取左、右子树染色状态的dp表
    //- 左子树
    int[] l = postOrderTraversal(root.left, k);
    //- 右子树
    int[] r = postOrderTraversal(root.right, k);
    //3.更新处理root 染色/不染色 的情况下的dp表
    //- 不染root
    int ml = Integer.MIN_VALUE, mr = Integer.MIN_VALUE;
    for (int i = 0; i <= k; i++) {
      //- 分别取子节点的最大值
      ml = Math.max(ml, l[i]);
      mr = Math.max(mr, r[i]);
    }
    dp[0] = ml + mr;
    //- 染root
    for (int i = 1; i <= k; i++) {
      for (int j = 0; j < i; j++) {
        //- 还需要染色 i - 1 个点，左子树 j 个，右子树 i-1-j 个
        dp[i] = Math.max(dp[i], root.val + l[j] + r[i - 1 - j]);
      }
    }
    //4.更新完毕，返回后继续向上动态规划
    return dp;
  }

}