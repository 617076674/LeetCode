package question_guess_numbers;

/**
 * 执行用时：0ms，击败100.00%。消耗内存：36.4MB，击败5.58%。
 */
public class Solution {
    public int game(int[] guess, int[] answer) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                result++;
            }
        }
        return result;
    }
}