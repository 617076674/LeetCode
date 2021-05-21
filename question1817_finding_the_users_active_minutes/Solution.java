package question1817_finding_the_users_active_minutes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> id2ActiveSet = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> set = id2ActiveSet.get(log[0]);
            if (null == set) {
                set = new HashSet<>();
                set.add(log[1]);
                id2ActiveSet.put(log[0], set);
            } else {
                set.add(log[1]);
            }
        }
        Map<Integer, Integer> active2Count = new HashMap<>();
        for (Set<Integer> set : id2ActiveSet.values()) {
            int count = set.size();
            active2Count.put(count, active2Count.getOrDefault(count, 0) + 1);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = active2Count.getOrDefault(i + 1, 0);
        }
        return result;
    }

}