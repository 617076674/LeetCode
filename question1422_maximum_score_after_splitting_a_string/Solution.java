package question1422_maximum_score_after_splitting_a_string;

/**
 * 执行用时：2ms，击败65.23%。消耗内存：37.5MB，击败100.00%。
 */
public class Solution {
    public int maxScore(String s) {
        int[] count0 = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i == 0) {
                    count0[i] = 1;
                } else {
                    count0[i] = count0[i - 1] + 1;
                }
            } else {
                if (i != 0) {
                    count0[i] = count0[i - 1];
                }
            }
        }
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            result = Math.max(result, count0[i] + s.length() - 1 - i - count0[s.length() - 1] + count0[i]);
        }
        return result;
    }
}