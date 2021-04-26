package question1177_can_make_palindrome_from_substring;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] maps = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                maps[i + 1][j] = maps[i][j];
            }
            maps[i + 1][s.charAt(i) - 'a']++;
        }
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int odd = 0;
            for (int i = 0; i < 26; i++) {
                if (((maps[query[1] + 1][i] - maps[query[0]][i]) & 1) == 1) {
                    odd++;
                }
            }
            result.add(query[2] >= odd / 2);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcda";
        int[][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        System.out.println(new Solution().canMakePaliQueries(s, queries));
    }

}