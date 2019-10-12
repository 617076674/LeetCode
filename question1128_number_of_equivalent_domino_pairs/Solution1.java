package question1128_number_of_equivalent_domino_pairs;

import java.util.Arrays;

/**
 * 排序后判断。
 *
 * 时间复杂度是O(nlogn)，其中n为dominoes数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：56ms，击败13.41%。消耗内存：56.1MB，击败100.00%。
 */
public class Solution1 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        for (int i = 0; i < n; i++) {
            if (dominoes[i][0] > dominoes[i][1]) {
                int tmp = dominoes[i][0];
                dominoes[i][0] = dominoes[i][1];
                dominoes[i][1] = tmp;
            }
        }
        Arrays.sort(dominoes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int result = 0;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j + 1 < n && dominoes[i][0] == dominoes[j + 1][0] && dominoes[i][1] == dominoes[j + 1][1]) {
                j++;
            }
            result += ((j - i) * (j - i + 1)) >> 1;
            i = j + 1;
        }
        return result;
    }
}
