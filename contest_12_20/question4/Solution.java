package contest_12_20.question4;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    private int[] parent;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.sort(edgeList, Comparator.comparingInt(edge -> edge[2]));
        Integer[] indexes = new Integer[queries.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, Comparator.comparingInt(num -> queries[num][2]));
        boolean[] result = new boolean[queries.length];
        int edgeIndex = 0;
        for (int index : indexes) {
            while (edgeIndex < edgeList.length && edgeList[edgeIndex][2] < queries[index][2]) {
                union(edgeList[edgeIndex][0], edgeList[edgeIndex][1]);
                edgeIndex++;
            }
            result[index] = findParent(queries[index][0]) == findParent(queries[index][1]);
        }
        return result;
    }

    private void union(int a, int b) {
        int aParent = findParent(a), bParent = findParent(b);
        if (aParent != bParent) {
            parent[aParent] = bParent;
        }
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

}