package question1196_how_many_apples_can_you_put_into_the_basket;

import java.util.Arrays;

/**
 * 贪心算法，尽量拿重量小的苹果。
 *
 * 时间复杂度是O(nlogn)，其中n为数组arr的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败99.28%。消耗内存：39.3MB，击败20.00%。
 */
public class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > 5000) {
                return i;
            }
        }
        return arr.length;
    }
}