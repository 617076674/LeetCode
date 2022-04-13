package question0968_binary_tree_cameras;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<TreeNode, Integer[]> memo = new HashMap<>();

    public int minCameraCover(TreeNode root) {
      return minCameraCoverHelper(root, 1);
    }

    private int minCameraCoverHelper(TreeNode cur, int parentStatus) {
      if (null == cur) {
        return 0;
      }
      Integer[] res = memo.get(cur);
      if (null != res && res[parentStatus] != null) {
        return res[parentStatus];
      }
      int result;
      if (parentStatus == 0) {
        result = 1 + minCameraCoverHelper(cur.left, 2) + minCameraCoverHelper(cur.right, 2);
      } else if (parentStatus == 1) {
        if (cur.left == null && cur.right == null) {
          result = 1;
        } else {
          result = 1 + minCameraCoverHelper(cur.left, 2) + minCameraCoverHelper(cur.right, 2);
          if (cur.left == null) {
            result = Math.min(result, 1 + minCameraCoverHelper(cur.right.left, 2) + minCameraCoverHelper(cur.right.right, 2));
          } else if (cur.right == null) {
            result = Math.min(result, 1 + minCameraCoverHelper(cur.left.left, 2) + minCameraCoverHelper(cur.left.right, 2));
          } else {
            result = Math.min(result, 1 + minCameraCoverHelper(cur.right.left, 2) + minCameraCoverHelper(cur.right.right, 2) + minCameraCoverHelper(cur.left, 1));
            result = Math.min(result, 1 + minCameraCoverHelper(cur.left.left, 2) + minCameraCoverHelper(cur.left.right, 2) + minCameraCoverHelper(cur.right, 1));
          }
        }
      } else {
        result = Math.min(minCameraCoverHelper(cur.left, 1) + minCameraCoverHelper(cur.right, 1), 1 + minCameraCoverHelper(cur.left, 2) + minCameraCoverHelper(cur.right, 2));
      }
      if (null == res) {
        res = new Integer[3];
        memo.put(cur, res);
      }
      res[parentStatus] = result;
      return result;
    }

}