package question0582_kill_process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 并查集。
 *
 * 执行用时：21ms，击败98.81%。消耗内存：47.9MB，击败26.24%。
 */
public class Solution {

    private int[] parent;

    private int n;

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        n = pid.size();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Map<Integer, Integer> pId2Index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pId2Index.put(pid.get(i), i);
        }
        for (int i = 0; i < n; i++) {
            if (pid.get(i) != kill && ppid.get(i) != 0) {
                unionTwo(i, pId2Index.get(ppid.get(i)));
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (findParent(i) == pId2Index.get(kill)) {
                list.add(pid.get(i));
            }
        }
        return list;
    }

    private void unionTwo(int a, int b) {
        int aParent = findParent(a);
        int bParent = findParent(b);
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
            int z = a;
            a = parent[a];
            parent[z] = x;
        }
        return x;
    }

}