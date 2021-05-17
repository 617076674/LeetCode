package question1593_split_a_string_into_the_max_number_of_unique_substrings;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    private int result;

    public int maxUniqueSplit(String s) {
        dfs(s, 0, new HashSet<>());
        return result;
    }

    private void dfs(String s, int start, Set<String> set) {
        if (start == s.length()) {
            result = Math.max(result, set.size());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String tempS = s.substring(start, i + 1);
            if (!set.contains(tempS)) {
                set.add(tempS);
                dfs(s, i + 1, set);
                set.remove(tempS);
            }
        }
    }

}