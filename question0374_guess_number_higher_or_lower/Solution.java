package question0374_guess_number_higher_or_lower;

/**
 * 二分查找法。
 *
 * 时间复杂度是O(logn)。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败90.28%。消耗内存：33.3MB，击败67.19%。
 */
public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (true) {
            int mid = left + ((right - left) >> 1);
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

}