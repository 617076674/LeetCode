package question1262_greatest_sum_divisible_by_three;

/**
 * 计算 nums 数组总和 sum 的过程中记录下除 3 余数是 1 和 2 的最小的两个元素。
 *
 * 如果 sum 除 3 余数是 0，直接返回 sum即可。
 *
 * 如果 sum 除 3 余数是 1，可以剔除 1 个除 3 余数为 1 的最小元素，也可以剔除 2 个除 3 余数为 2 的最小元素。
 *
 * 如果 sum 除 3 余数是 2，可以剔除 1 个除 3 余数为 2 的最小元素，也可以剔除 2 个除 3 余数为 1 的最小元素。
 *
 * 时间复杂度是 O(n)，其中 n 为 nums 数组的长度。空间复杂度是 O(1)。
 *
 * 执行用时：4ms，击败97.84%。消耗内存：46MB，击败25.00%。
 */
public class Solution {
    public int maxSumDivThree(int[] nums) {
        int remainder11 = 10001, remainder12 = 10001, remainder21 = 10001, remainder22 = 10001, sum = 0;
        for (int num : nums) {
            sum += num;
            int remainder = num % 3;
            if (remainder == 1) {
                if (num < remainder11) {
                    remainder12 = remainder11;
                    remainder11 = num;
                } else if (num < remainder12) {
                    remainder12 = num;
                }
            } else if (remainder == 2) {
                if (num < remainder21) {
                    remainder22 = remainder21;
                    remainder21 = num;
                } else if (num < remainder22) {
                    remainder22 = num;
                }
            }
        }
        int remainder = sum % 3;
        if (remainder == 0) {
            return sum;
        } else if (remainder == 1) {
            return Math.max(sum - remainder11, sum - remainder21 - remainder22);
        }
        return Math.max(sum - remainder11 - remainder12, sum - remainder21);
    }
}