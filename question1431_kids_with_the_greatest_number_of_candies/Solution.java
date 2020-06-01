package question1431_kids_with_the_greatest_number_of_candies;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度是 O(n)，其中 n 为 candies 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：1ms，击败99.84%。消耗内存：39.8MB，击败100.00%。
 */
public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}