package question0410_split_array_largest_sum;

/**
 * 贪心算法+二分查找法。
 *
 * 如果我们找到了一种分割方案，使得最大的分割子数组和不超过x，那么我们也能找到一种分割方案使得最大的分割子数组和不超过y，其中y大于x。
 *
 * 对于值x，我们把这个性质定义为F(x)。如果F(x)为真，那就意味着我们一定可以找到一种分割方案使得最大的分割子数组和不超过x。
 *
 * 我们让x的区间为(-∞, +∞)，一旦我们找到一个值x0，使得所有的x<x0，F(x)都为假，所有的x>=x0，F(x)都为真。那么显然，这个x0就是我们的答案。
 *
 * 我们可以用二分搜索来找到x0。每次循环，我们让mid=(left+right)/2，如果F(mid)为假，那么我们接下来就去搜索[mid + 1, right]区间；
 * 如果F(mid)为真，那么我们接下来就去搜索[left, mid-1]区间。
 *
 * 对于一个给定的x，我们可以用贪心算法来计算F(x)。我们用累计和sum来记录当前子数组的和，同时用cnt来记录子数组的数量。
 * 我们依次处理数组中的每个元素，对每个元素num，如果sum+num<=x，这就意味着当前的子数组没有超过限制。
 * 否则，就需要从当前元素num开始分割出一个新的子数组。
 *
 * 在完成遍历完整个数组之后，比较cnt和m的值。如果cnt<=m，这就意味可以找到一种分割方案使得最大的分割子数组和不超过x。否则，F(x)一定为假。
 *
 * 时间复杂度是O(n * log(m))，其中m为nums数组中所有的元素和。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败95.79%。消耗内存：35MB，击败47.46%。
 */
public class Solution2 {
    public int splitArray(int[] nums, int m) {
        long left = 0, right = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        long result = right;
        while (left <= right) {
            long mid = left + ((right - left) >> 1), sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    cnt ++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if (cnt <= m) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) result;
    }

}