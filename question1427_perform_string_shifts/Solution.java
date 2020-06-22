package question1427_perform_string_shifts;

/**
 * 暴力破解法
 *
 * 执行用时：1ms，击败26.92%。消耗内存：38MB，击败100.00%。
 */
public class Solution {
    public String stringShift(String s, int[][] shift) {
        for (int[] move : shift) {
            if (move[0] == 0) {
                s = leftMove(s, move[1]);
            } else {
                s = rightMove(s, move[1]);
            }
        }
        return s;
    }

    private String leftMove(String s, int amount) {
        return s.substring(amount) + s.substring(0, amount);
    }

    private String rightMove(String s, int amount) {
        return s.substring(s.length() - amount) + s.substring(0, s.length() - amount);
    }
}