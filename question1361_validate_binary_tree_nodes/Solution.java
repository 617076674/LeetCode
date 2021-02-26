package question1361_validate_binary_tree_nodes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 一颗二叉树需要满足两个条件：
 *
 * （1）除根节点外，所有的节点有且仅有一个父节点。
 *
 * （2）只有一个根节点。
 *
 * （3）通过根节点可以访问到其它所有节点。
 *
 * 时间复杂度和空间复杂度均是O(n)。
 *
 * 执行用时：3ms，击败100.00%。消耗内存：42.5MB，击败100.00%。
 */
public class Solution {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                if (parent[leftChild[i]] != -1) {
                    return false;
                }
                parent[leftChild[i]] = i;
            }
            if (rightChild[i] != -1) {
                if (parent[rightChild[i]] != -1) {
                    return false;
                }
                parent[rightChild[i]] = i;
            }
        }
        int rootCnt = 0, root = -1;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                rootCnt++;
                root = i;
            }
        }
        if (rootCnt != 1) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        int visited = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited++;
            if (-1 != leftChild[now]) {
                queue.add(leftChild[now]);
            }
            if (-1 != rightChild[now]) {
                queue.add(rightChild[now]);
            }
        }
        return visited == n;
    }

}