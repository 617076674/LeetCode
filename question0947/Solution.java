package question0947;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 并查集。
 *
 * 注意题意：move 操作将会移除与网格上的某一块石头共享一列或一行的一块石头。
 *
 * 如果只有一块石头，显然没有任何其他石头与它处于同一行或同一列，move次数是0。
 *
 * 如果所有石头均不在同一行或同一列，那么move次数也是0。
 *
 * 因此我们只需要找出通过同一行/同一列关系连接起来的集合数量，用总数减去集合总数就是move操作的次数。
 *
 * 还有一个问题是：我们如何建立我们的并查集，我们合并的是点吗？这样的时间复杂度太高了。事实上，我们只需要合并stones中出现的行与列即可。
 *
 * 时间复杂度是O(nlogn)，其中n是stones数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：8ms，击败96.67%。消耗内存：42.2MB，击败92.00%。
 */
public class Solution {
    private int[] parent = new int[20000];

    public int removeStones(int[][] stones) {
        int n = stones.length;
        if (n == 0) {
            return 0;
        }
        //初始化并查集
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            union(stones[i][0], stones[i][1] + 10000);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(findFather(stones[i][0]));
        }
        return n - set.size();
    }

    private int findFather(int x) {
        int a = x;
        while (x != parent[x]) {
            x = parent[x];
        }
        while (a != parent[a]) {
            int z = a;
            a = parent[a];
            parent[z] = x;
        }
        return x;
    }

    private void union(int a, int b) {
        int aFather = findFather(a), bFather = findFather(b);
        if (aFather != bFather) {
            parent[aFather] = bFather;
        }
    }
}
