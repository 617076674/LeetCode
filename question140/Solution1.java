package question140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        //canBreak[i][j]表示[i, j]子串能否被分割
        boolean[][] canBreak = new boolean[n][n];
        //results[i][j]表示[i, j]子串被分割的结果
        Set<String>[][] results = new HashSet[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                results[i][j] = new HashSet<>();
                if(i == j){
                    String str = s.substring(i, i + 1);
                    canBreak[i][i] = include(str, wordDict);
                    if (canBreak[i][i]) {
                        results[i][i].add(str);
                    }
                }
            }
        }
        for (int gap = -1; gap >= - n + 1; gap--) {
            for (int i = 0; i <= gap + n - 1; i++) {
                String str = s.substring(i, i - gap + 1);
                canBreak[i][i - gap] = include(str, wordDict);
                if (canBreak[i][i - gap]) {
                    results[i][i - gap].add(str);
                }
                for (int j = -gap - 1; j >= 0; j--) {
                    if (canBreak[i][i + j] && canBreak[i + j + 1][i - gap]) {
                        canBreak[i][i - gap] = true;
                        Set<String> set1 = results[i][i + j];
                        Set<String> set2 = results[i + j + 1][i - gap];
                        for(String str1 : set1){
                            for(String str2 : set2){
                                results[i][i - gap].add(str1 + " " + str2);
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>(results[0][n - 1]);
    }
    private boolean include(String string, List<String> wordDict) {
        for (String s : wordDict) {
            if (s.equals(string)) {
                return true;
            }
        }
        return false;
    }
}