package question139;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[][] results = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            results[i][i] = include(s.substring(i, i + 1), wordDict);
        }
        for (int gap = -1; gap >= - n + 1; gap--) {
            for (int i = 0; i <= gap + n - 1; i++) {
                results[i][i - gap] = include(s.substring(i, i - gap + 1), wordDict);
                if(!results[i][i - gap]) {
                    for (int j = 0; j < - gap; j++) {
                        if(results[i][i + j] && results[i + j + 1][i - gap]) {
                            results[i][i - gap] = true;
                            break;
                        }
                    }
                }
            }
        }
        return results[0][n - 1];
    }
    private boolean include(String string, List<String> wordDict) {
        for (String s : wordDict) {
            if(s.equals(string)) {
                return true;
            }
        }
        return false;
    }
}
