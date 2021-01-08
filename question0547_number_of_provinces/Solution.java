package question0547_number_of_provinces;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private int[] parent;

    public int findCircleNum(int[][] isConnected) {
        parent = new int[isConnected.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < parent.length; i++) {
            set.add(findParent(i));
        }
        return set.size();
    }

    private int findParent(int x) {
        int a = x;
        while (x != parent[x]) {
            x = parent[x];
        }
        while (a != parent[a]) {
            int z = parent[a];
            parent[a] = x;
            a = z;
        }
        return x;
    }

    private void union(int a, int b) {
        int aParent = findParent(a), bParent = findParent(b);
        if (aParent != bParent) {
            parent[aParent] = bParent;
        }
    }

}