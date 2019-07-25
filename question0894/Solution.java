package question0894;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-07-25
 *
 * 递归。
 *
 * 时间复杂度和空间复杂度均是O(N ^ 2)。
 *
 * 执行用时：14ms，击败39.89%。消耗内存：54.2MB，击败24.66%。
 */
public class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> result = new ArrayList<>();
        if ((N & 1) == 0) {
            return result;
        }
        if (N == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        for (int i = 1; N - i - 1 >= 1; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);
            for (TreeNode node1 : left) {
                for (TreeNode node2 : right) {
                    TreeNode treeNode = new TreeNode(0);
                    treeNode.left = node1;
                    treeNode.right = node2;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }
}
