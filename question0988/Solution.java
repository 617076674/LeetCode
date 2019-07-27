package question0988;

/**
 * @author qianyihui
 * @date 2019-07-27
 *
 * 回溯法。
 *
 * 时间复杂度是O(n)，其中n为树中的节点个数。空间复杂度是O(h)，其中h为树的高度。
 *
 * 执行用时：8ms，击败38.03%。消耗内存：39.1MB，击败75.38%。
 */
public class Solution {
    private String result = null;

    private char[] map = new char[26];

    public String smallestFromLeaf(TreeNode root) {
        for (int i = 0; i < 26; i++) {
            map[i] = (char) ('a' + i);
        }
        dfs(root, new StringBuilder());
        return result;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {      //叶子节点
            sb.append(map[root.val]);
            StringBuilder tmp = new StringBuilder(sb);
            String tmpResult = tmp.reverse().toString();
            if (result == null) {
                result = tmpResult;
            } else {
                if (result.compareTo(tmpResult) > 0) {
                    result = tmpResult;
                }
            }
            sb.deleteCharAt(sb.length() - 1);   //注意变量的回溯
            return;
        }
        sb.append(map[root.val]);
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length() - 1);   //注意变量的回溯
    }
}
