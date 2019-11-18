package question0011_container_with_most_water;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 设立两个指针，一个从头一个从尾，相向而行遍历数组，每次舍弃较短边
 * （1）计算面积最大值的初值，该初值以数组中的第一个元素和最后一个元素构成两边。
 * （2）设置首尾两个指针，首指针i指向数组中的第一个元素，尾指针j指向数组中的最后一个元素。
 * （3）当首指针i小于尾指针j时，一直循环计算其面积。若计算所得的当前面积大于（1）步骤中所计算得的面积最大值，则更新最大值。
 * 每一次循环都舍弃索引i和索引j中较短的那一条边。
 *
 * 为什么每一次循环舍弃索引i和索引j中较短的那一条边，我们最终得到的结果就会是最大的面积值呢？
 *
 * 假设我们现在遍历到了height数组中第i和第j个元素，且height[i] < height[j]，如果我们的面积最大值中取了第i个元素，
 * 那么构成我们的面积最大值的两个元素一定是i和j，因为j继续减小的话长方形的宽肯定一直在减小，而其高最多只能是height[i]，
 * 不可能比height[i]更大，因此我们在继续遍历的过程中，继续保持i不变而减小j是没有意义的。我们可以直接舍弃i，从i + 1开始去继续遍历。
 *
 * 时间复杂度是O(n)，其中n为height数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：6ms，击败78.08%。消耗内存：44.5MB，击败68.02%。
 */
public class Solution2 {
    public int maxArea(int[] height) {
        int n = height.length, i = 0, j = n - 1, area = (n - 1) * Math.min(height[i], height[j]);
        while (i < j) {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return area;
    }
}