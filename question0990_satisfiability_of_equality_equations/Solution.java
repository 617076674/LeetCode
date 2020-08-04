package question0990_satisfiability_of_equality_equations;

/**
 * 并查集。
 *
 * 先将等式放入并查集中，再判断不等式的正确性。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为equations数组的长度。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：39.4MB，击败16.67%。
 */
public class Solution {
    private int[] parent = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '=') {
                union(equations[i].charAt(0) - 'a', equations[i].charAt(3) - 'a');
            }
        }
        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '!' &&
                    findParent(equations[i].charAt(0) - 'a') == findParent(equations[i].charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
    }

    private int findParent(int x) {
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
        int aFather = findParent(a), bFather = findParent(b);
        if (aFather != bFather) {
            parent[aFather] = bFather;
        }
    }
}