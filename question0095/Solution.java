package question0095;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。
 *
 * 时间复杂度和空间复杂度均是O(n!)，其中n为树中的节点个数。
 *
 * 执行用时：2ms，击败99.90%。消耗内存：37.4MB，击败88.89%。
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> result = new ArrayList<>();
        if (left == right) {
            TreeNode treeNode = new TreeNode(left);
            result.add(treeNode);
            return result;
        }
        for (int i = left; i <= right; i++) {
            if (i == left) {
                List<TreeNode> rightTreeNodeList = generateTrees(left + 1, right);
                for (TreeNode rightTreeNode : rightTreeNodeList) {
                    TreeNode tempNode = new TreeNode(i);
                    tempNode.right = rightTreeNode;
                    result.add(tempNode);
                }
            } else if (i == right) {
                List<TreeNode> leftTreeNodeList = generateTrees(left, right - 1);
                for (TreeNode leftTreeNode : leftTreeNodeList) {
                    TreeNode tempNode = new TreeNode(i);
                    tempNode.left = leftTreeNode;
                    result.add(tempNode);
                }
            } else {
                List<TreeNode> leftTreeNodeList = generateTrees(left, i - 1);
                List<TreeNode> rightTreeNodeList = generateTrees(i + 1, right);
                for (TreeNode leftTreeNode : leftTreeNodeList) {
                    for (TreeNode rightTreeNode : rightTreeNodeList) {
                        TreeNode tempNode = new TreeNode(i);
                        tempNode.left = leftTreeNode;
                        tempNode.right = rightTreeNode;
                        result.add(tempNode);
                    }
                }
            }
        }
        return result;
    }
}
