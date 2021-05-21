package question1849_splitting_a_string_into_descending_consecutive_values;

public class Solution {

    public boolean splitString(String s) {
        return dfs(s, 0, -1, 0);
    }

    private boolean dfs(String s, int index, long pre, int len) {
        if (index == s.length()) {
            return len != 1;
        }
        if (pre == -1) {
            for (int i = index + 1; i <= s.length(); i++) {
                Long cur;
                try {
                    cur = Long.parseLong(s.substring(0, i));
                } catch (Exception e) {
                    continue;
                }
                if (dfs(s, i, cur, len + 1)) {
                    return true;
                }
            }
        } else {
            for (int i = index + 1; i <= s.length(); i++) {
                Long cur;
                try {
                    cur = Long.parseLong(s.substring(index, i));
                } catch (Exception e) {
                    continue;
                }
                if (pre - 1 == cur) {
                    if (dfs(s, i, pre - 1, len + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}