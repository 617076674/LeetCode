package question1483_kth_ancestor_of_a_tree_node;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Lifting
 *
 * https://leetcode-cn.com/problems/kth-ancestor-of-a-tree-node/solution/li-kou-zai-zhu-jian-ba-acm-mo-ban-ti-ban-shang-lai/
 *
 * 时间复杂度是 O(n * logn)。空间复杂度是 O(n ^ 2)。
 *
 * 执行用时：185ms，击败19.06%。消耗内存：96.4MB，击败27.45%。
 */
public class TreeAncestor {

    // dp[i][j] 表示节点 i 的距离为 (2 ^ j) 的祖先
    private List<List<Integer>> dp = new ArrayList<>();

    public TreeAncestor(int n, int[] parent) {
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(parent[i]);
            dp.add(list);
        }
        for (int j = 1; ; j++) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                // 要想找到节点 i 的距离 (2 ^ j) 的祖先，
                // 1 - 先找到节点 i 的距离 (2 ^ (j - 1)) 的祖先，
                // 2 - 然后，在找这个祖先的距离 (2 ^ (j - 1)) 的祖先。
                // 即分两步得到节点 i 的距离为 (2 ^ j) 的祖先。
                int tmp = dp.get(i).get(j - 1) == -1 ? -1 : dp.get(dp.get(i).get(j - 1)).get(j - 1);
                dp.get(i).add(tmp);
                if (tmp != -1) {
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int result = node, position = 0;
        while (k > 0 && result != -1) {
            if (position >= dp.get(result).size()) {
                return -1;
            }
            if ((k & 1) == 1) {
                result = dp.get(result).get(position);
            }
            k >>= 1;
            position++;
        }
        return result;
    }

}