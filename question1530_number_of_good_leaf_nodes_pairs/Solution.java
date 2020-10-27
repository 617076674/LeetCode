package question1530_number_of_good_leaf_nodes_pairs;

import javafx.util.Pair;

/**
 * 对于二叉树的任意两个不同的叶子节点 A 和 B，一个重要的性质是：它们之间有且仅有一条最短路径。设两个叶子节点的最近公共祖
 * 先为 P，则最短路径的长度，等于 A 到 P 的距离，加上 B 到 P 的距离。
 *
 * 于是，我们遍历所有非叶子节点 P，找到以 P 为最近公共祖先的所有叶子节点时，并根据上面的等式，计算每一对之间的距离，并统
 * 计距离不超过 distance 的节点对数目，就能够得到最终的答案。
 *
 * 如何计算每个叶子节点之间的距离？（如何知道以 P 为根节点的子树中的所有叶子节点，它们与 P 之间的距离？）
 * 对于任意的节点 P，我们先通过递归的方式，统计叶子节点与 P 的左孩子 left、右孩子 right 之间的距离；这样，两个以 P 为
 * 最近公共祖先的叶子节点 A、B，其中一个（例如 A）在以 left 为根的子树中，另一个（例如 B）在以 right 为根的子树中。A
 * 与 B 之间的距离，就等于 A 与 left 之间的距离，加上 B 与 right 之间的距离，再加上 2。
 *
 * 由于本题中约束 distance <= 10，因此对于每个非叶子节点 P，只需开辟长度为 distance + 1 的数组 depths，其中
 * depths 表示与 P 之间的距离为 i 的叶子节点数目。
 *
 * 执行用时：4ms，击败79.44%。消耗内存：38.7MB，击败93.32%。
 */
public class Solution {

    private int distance;

    public int countPairs(TreeNode root, int distance) {
        this.distance = distance;
        return dfs(root).getValue();
    }

    // 对于 dfs(root,distance)，同时返回：
    // 1）每个叶子节点与 root 之间的距离
    // 2) 以 root 为根节点的子树中好叶子节点对的数量
    public Pair<int[], Integer> dfs(TreeNode root) {
        int[] depths = new int[distance + 1];
        if (root.left == null && root.right == null) {
            depths[0] = 1;  // 与 root 距离为 0 的叶子节点数量为 1 个
            return new Pair<>(depths, 0);
        }
        int[] leftDepths = new int[distance + 1];
        int[] rightDepths = new int[distance + 1];
        int leftCount = 0, rightCount = 0;
        if (root.left != null) {
            Pair<int[], Integer> leftPair = dfs(root.left);
            leftDepths = leftPair.getKey();
            leftCount = leftPair.getValue();
        }
        if (root.right != null) {
            Pair<int[], Integer> rightPair = dfs(root.right);
            rightDepths = rightPair.getKey();
            rightCount = rightPair.getValue();
        }
        for (int i = 0; i < distance; i++) {
            depths[i + 1] += leftDepths[i];
            depths[i + 1] += rightDepths[i];
        }
        int cnt = 0;
        for (int i = 0; i <= distance; i++) {
            for (int j = 0; j + i + 2 <= distance; j++) {
                cnt += leftDepths[i] * rightDepths[j];
            }
        }
        return new Pair<>(depths, cnt + leftCount + rightCount);
    }

}