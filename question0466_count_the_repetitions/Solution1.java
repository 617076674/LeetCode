package question0466_count_the_repetitions;

import java.util.Arrays;

/**
 * 暴力搜索法。
 *
 * 时间复杂度是O(n1 * len(s1))。空间复杂度是O(1)。
 *
 * 执行用时：102ms，击败56.10%。消耗内存：37.2MB，击败100.00%。
 */
public class Solution1 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] next = new int[len1][26];
        for (int i = 0; i < next.length; i++) {
            Arrays.fill(next[i], Integer.MAX_VALUE);
            for (int j = i; j < len1; j++) {
                char c = s1.charAt(j);
                next[i][c - 'a'] = Math.min(next[i][c - 'a'], j);
            }
        }
        // index1为s1的索引，index2为s2的索引， num1当前使用了s1的个数， num2当前匹配的s2的个数
        int index1 = 0, index2 = 0, num1 = 0, num2 = 0;
        while (num1 < n1) {
            if (index1 == 0 && index2 == 0 && num1 != 0) {
                return n1 * num2 / (num1 * n2);
            }
            int i = next[index1][s2.charAt(index2) - 'a'];
            if (i < len1) {
                if (index2 == len2 - 1) {
                    index2 = 0;
                    num2++;
                } else {
                    index2++;
                }
                index1 = i + 1;
                if (index1 == len1) {
                    index1 = 0;
                    num1++;
                }
            } else {
                num1++;
                index1 = 0;
            }
        }
        return num2 / n2;
    }
}