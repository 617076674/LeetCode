package question0881;

import java.util.Arrays;

/**
 * 排序后双指针。
 *
 * 时间复杂度是O(nlog(n))，其中n为people数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：51ms，击败14.87%。消耗内存：55.3MB，击败42.22%。
 */
public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length, left = 0, right = n - 1, result = 0;
        while (left < right) {
            if (people[left] + people[right] <= limit) {    //left和right共用一条船
                left++;
                right--;
            } else {    //right单独用一条船
                right--;
            }
            result++;
        }
        if (left == right) {
            result++;
        }
        return result;
    }
}
