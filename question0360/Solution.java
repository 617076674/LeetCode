package question0360;

/**
 * 根据函数的单调性先确定最低点或最高点，再用双指针遍历。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败96.30%。消耗内存：37MB，击败100.00%。
 */
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return new int[0];
        }
        int[] result = new int[n];
        if (a > 0) {    //先递减后递增，找到最小值
            int min = 0;
            for (int i = 1; i < n; i++) {
                if (calculate(a, b, c, nums[i]) < calculate(a, b, c, nums[min])) {
                    min = i;    //寻找到最低点的索引
                }
            }
            result[0] = calculate(a, b, c, nums[min]);
            int index = 1, index1 = min - 1, index2 = min + 1;
            while (true) {
                if (index1 < 0 && index2 >= n) {
                    break;
                }
                if (index1 < 0) {
                    result[index++] = calculate(a, b, c, nums[index2]);
                    index2++;
                } else if (index2 >= n) {
                    result[index++] = calculate(a, b, c, nums[index1]);
                    index1--;
                } else if (calculate(a, b, c, nums[index1]) <= calculate(a, b, c, nums[index2])) {
                    result[index++] = calculate(a, b, c, nums[index1]);
                    index1--;
                } else {
                    result[index++] = calculate(a, b, c, nums[index2]);
                    index2++;
                }
            }
        } else if (a == 0) {
            if (b >= 0) {    //一直递增
                for (int i = 0; i < n; i++) {
                    result[i] = calculate(a, b, c, nums[i]);
                }
            } else {    //一直递减
                for (int i = 0; i < n; i++) {
                    result[i] = calculate(a, b, c, nums[n - 1 - i]);
                }
            }
        } else {    //先递增后递减
            int max = 0;
            for (int i = 1; i < n; i++) {
                if (calculate(a, b, c, nums[i]) > calculate(a, b, c, nums[max])) {
                    max = i;    //寻找到最高点的索引
                }
            }
            result[n - 1] = calculate(a, b, c, nums[max]);
            int index = n - 2, index1 = max - 1, index2 = max + 1;
            while (true) {
                if (index1 < 0 && index2 >= n) {
                    break;
                }
                if (index1 < 0) {
                    result[index--] = calculate(a, b, c, nums[index2]);
                    index2++;
                } else if (index2 >= n) {
                    result[index--] = calculate(a, b, c, nums[index1]);
                    index1--;
                } else if (calculate(a, b, c, nums[index1]) >= calculate(a, b, c, nums[index2])) {
                    result[index--] = calculate(a, b, c, nums[index1]);
                    index1--;
                } else {
                    result[index--] = calculate(a, b, c, nums[index2]);
                    index2++;
                }
            }
        }
        return result;
    }

    private int calculate(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}
