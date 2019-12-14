package question0536_construct_binary_tree_from_string;

/**
 * 递归构建二叉树。
 *
 * 执行用时：15ms，击败70.55%。消耗内存：42.8MB，击败100.00%。
 */
public class Solution {
    public TreeNode str2tree(String s) {
        int n = s.length();
        if (0 == n) {
            return null;
        }
        if (s.charAt(0) == '(') {
            s = s.substring(1, s.length() - 1);
        }
        int index1 = s.indexOf('(');
        if (index1 == -1) {
            return new TreeNode(Integer.parseInt(s));
        }
        int left = 0, right = 0, i = index1;
        while (true) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
            }
            if (left == right) {
                break;
            }
            i++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, index1)));
        root.left = str2tree(s.substring(index1, i + 1));
        root.right = str2tree(s.substring(i + 1));
        return root;
    }
}