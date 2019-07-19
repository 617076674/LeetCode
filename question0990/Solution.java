package question0990;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qianyihui
 * @date 2019-07-19
 *
 * 并查集。
 *
 * 先将等式放入并查集中，再判断不等式的正确性。
 *
 * 时间复杂度和空间复杂度均是O(n)，其中n为equations数组的长度。
 */
public class Solution {
    private int[] parent = new int[26];

    public boolean equationsPossible(String[] equations) {
        //初始化并查集
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        List<String> needChecked = new ArrayList<>();
        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '=') {
                union(equations[i].charAt(0) - 'a', equations[i].charAt(3) - 'a');
            } else {
                needChecked.add(equations[i]);
            }
        }
        for (String string : needChecked) {
            if (findFather(string.charAt(0) - 'a') == findFather(string.charAt(3) - 'a')) {
                return false;
            }
        }
        return true;
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