package question5170_validate_binary_tree_nodes;

import java.util.Arrays;

/**
 * 一颗二叉树需要满足两个条件：
 *
 * （1）除根节点外，所有的节点有且仅有一个父节点。
 *
 * （2）只有一个根节点。
 *
 * 时间复杂度和空间复杂度均是O(n)。
 *
 * 执行用时：3ms，击败100.00%。消耗内存：42.5MB，击败100.00%。
 */
public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] isNotRoot = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            if (-1 != leftChild[i]) {
                isNotRoot[leftChild[i]] = true;
                if (parent[leftChild[i]] == -1) {
                    parent[leftChild[i]] = i;
                } else if (parent[leftChild[i]] != i) {
                    return false;
                }
            }
            if (-1 != rightChild[i]) {
                isNotRoot[rightChild[i]] = true;
                if (parent[rightChild[i]] == -1) {
                    parent[rightChild[i]] = i;
                } else if (parent[rightChild[i]] != i) {
                    return false;
                }
            }
        }
        int countRoot = 0;
        for (int i = 0; i < n; i++) {
            if (!isNotRoot[i] && ++countRoot > 1) {
                return false;
            }
        }
        return countRoot == 1;
    }
}