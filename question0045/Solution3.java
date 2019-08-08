package question0045;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82751536
 *
 * 和question0055中的Solution4同样的思路。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：4ms，击败78.42%。消耗内存：42MB，击败68.36%。
 */
public class Solution3 {
    public int jump(int[] nums) {
        int n = nums.length, steps = 0, i = 0;
        while (i < n - 1) {
            steps++;
            if (i + nums[i] >= n - 1) {
                return steps;
            }
            int k = i + 1;
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if (j + nums[j] > k + nums[k]) {    //选取k的原则是i + k + nums[k]达到最大
                    k = j;
                }
            }
            i = k;  //下一步是索引k
        }
        return steps;
    }
}
