package question0721_accounts_merge;

import java.util.*;

/**
 * 并查集。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为 accounts 中的字符串数量。
 *
 * 执行用时：49ms，击败61.32%。消耗内存：43.7MB，击败100.00%。
 */
public class Solution {
    private Map<String, Integer> email2Id = new HashMap<>();

    private Map<String, String> email2Name = new HashMap<>();

    private int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int index = 0;
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String s = account.get(j);
                if (!email2Id.containsKey(s)) {
                    email2Id.put(s, index++);
                }
                email2Name.put(s, account.get(0));
            }
        }
        parent = new int[email2Id.size()];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (List<String> account : accounts) {
            for (int i = 2; i < account.size(); i++) {
                union(email2Id.get(account.get(i - 1)), email2Id.get(account.get(i)));
            }
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (String email : email2Id.keySet()) {
            int emailParent = findParent(email2Id.get(email));
            if (!map.containsKey(emailParent)) {
                map.put(emailParent, new ArrayList<>());
            }
            map.get(emailParent).add(email);
        }
        for (List<String> emails : map.values()) {
            Collections.sort(emails);
            emails.add(0, email2Name.get(emails.get(0)));
        }
        return new ArrayList<>(map.values());
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
            int z = a;
            a = parent[a];
            parent[z] = x;
        }
        return x;
    }
}