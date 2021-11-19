package question0952_largest_component_size_by_common_factor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    private static class UnionFind {

        int[] parent;

        int n;

        int setCount;

        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
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

    public int largestComponentSize(int[] nums) {
        Set<Integer> factorSet = new HashSet<>();
        List<Integer>[] factorLists = new ArrayList[nums.length];
        for (int i = 0; i < nums.length; i++) {
            factorLists[i] = getFactors(nums[i]);
            factorSet.addAll(factorLists[i]);
        }
        Map<Integer, Integer> factor2Index = new HashMap<>();
        int index = 0;
        for (int factor : factorSet) {
            factor2Index.put(factor, index++);
        }
        UnionFind unionFind = new UnionFind(index);
        for (int i = 0; i < factorLists.length; i++) {
            for (int j = 1; j < factorLists[i].size(); j++) {
                unionFind.union(factor2Index.get(factorLists[i].get(0)), factor2Index.get(factorLists[i].get(j)));
            }
        }
        Map<Integer, Integer> parent2Count = new HashMap<>();
        for (List<Integer> factorList : factorLists) {
            if (factorList.isEmpty()) {
                continue;
            }
            int p = unionFind.findParent(factor2Index.get(factorList.get(0)));
            parent2Count.put(p, parent2Count.getOrDefault(p, 0) + 1);
        }
        int result = 1;
        for (int count : parent2Count.values()) {
            result = Math.max(result, count);
        }
        return result;
    }

    private static List<Integer> getFactors(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if ((num % i) == 0) {
                list.add(i);
                list.add(num / i);
            }
        }
        if (num > 1) {
            list.add(num);
        }
        return list;
    }

}