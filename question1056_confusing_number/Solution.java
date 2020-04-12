package question1056_confusing_number;

/**
 * 时间复杂度是O(logN)。空间复杂度是O(1)。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：36.6MB，击败50.00%。
 */
public class Solution {
    public boolean confusingNumber(int N) {
        int[] map = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
        int tmp = N, flipNum = 0;
        while (tmp > 0) {
            int num = tmp % 10;
            if (map[num] == -1) {
                return false;
            }
            flipNum = flipNum * 10 + map[num];
            tmp /= 10;
        }
        return N != flipNum;
    }
}