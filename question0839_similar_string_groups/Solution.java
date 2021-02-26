package question0839_similar_string_groups;

public class Solution {

    private static class UnionFind {

        int[] parent;

        int n;

        int setCount;

        public UnionFind(int n) {
            this.n = n;
            this.parent = new int[n];
            this.setCount = n;
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int findParent(int x) {
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

        public boolean union(int a, int b) {
            int aParent = findParent(a), bParent = findParent(b);
            if (aParent != bParent) {
                parent[aParent] = bParent;
                setCount--;
                return true;
            }
            return false;
        }

    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.setCount;
    }

    private static boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            if (diff > 2) {
                return false;
            }
        }
        return diff == 2 || diff == 0;
    }

}