package question1626_best_team_with_no_conflicts;

import java.util.Arrays;

/**
 * 排序 + 动态规划。
 *
 * 时间复杂度是 O(n ^ 2)，其中 n 为球员数量。空间复杂度是 O(n)。
 *
 * 执行用时：105ms，击败100.00%。消耗内存：38.9MB，击败100.00%。
 */
public class Solution {

    private int[] memo;

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        memo = new int[n];
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, (num1, num2) -> {
            if (ages[num1] == ages[num2]) {
                return scores[num1] - scores[num2];
            }
            return ages[num1] - ages[num2];
        });
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, bestTeamScore(indexes, scores, ages, i));
        }
        return result;
    }

    /**
     * 最后一名队员的编号是 indexes[index]，所能取得的最大分数
     */
    private int bestTeamScore(Integer[] indexes, int[] scores, int[] ages, int index) {
        if (index == 0) {
            return scores[indexes[index]];
        }
        if (memo[index] != 0) {
            return memo[index];
        }
        memo[index] = scores[indexes[index]];
        for (int i = 0; i < index; i++) {
            if (ages[indexes[i]] >= ages[indexes[index]] || scores[indexes[i]] <= scores[indexes[index]]) {
                memo[index] = Math.max(scores[indexes[index]] + bestTeamScore(indexes, scores, ages, i), memo[index]);
            }
        }
        return memo[index];
    }

}