package question0744;

/**
 * @author qianyihui
 * @date 2019-08-15
 *
 * ceil函数的运用。
 *
 * 时间复杂度是O(nlogn)，其中n为letters数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败96.99%。消耗内存：43.8MB，击败72.76%。
 */
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int result = ceil(letters, target);
        if (result == letters.length) {
            return letters[0];
        }
        return letters[result];
    }

    private int ceil(char[] letters, char target) {
        int left = 0, right = letters.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
