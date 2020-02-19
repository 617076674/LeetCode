package question1002_find_common_characters;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度是O(k)，其中k为A中的字符个数。空间复杂度是O(n)，其中n为A的长度。
 *
 * 执行用时：15ms，击败20.61%。消耗内存：43.3MB，击败5.09%。
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int n;
        if (null == A || (n = A.length) == 0) {
            return result;
        }
        int[][] count = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                count[i][A[i].charAt(j) - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, count[j][i]);
                if (min == 0) {
                    break;
                }
            }
            for (int j = 0; j < min; j++) {
                result.add("" + (char) (i + 'a'));
            }
        }
        return result;
    }
}