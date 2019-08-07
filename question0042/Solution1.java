package question0042;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82682179
 *
 * 分别计算每一层能接的雨水数，再逐层累加得到结果。
 *
 * 时间复杂度是O(maxHeight * n)，其中maxHeight是最大柱子高度，n是height数组的长度。空间复杂度是O(1)。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
    public int trap(int[] height) {
        int n = height.length, result = 0;
        if (n == 0) {
            return result;
        }
        int maxHeight = height[0];  //计算柱子的最大高度
        for (int i = 1; i < n; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
            }
        }
        for (int i = 0; i < maxHeight; i++) {   //分别计算每一层能接的雨水数
            int left = 0, right = n - 1;
            //最左侧其高度如果小于等于0，是无法接水的
            //如题给的例子[0,1,0,2,1,0,1,3,2,1,2,1]，显然对于第1层来说，其最左侧的0是不能盛水的
            while (left < n && height[left] - i <= 0) {
                left++;
            }
            //同理，最右侧其高度如果小于等于0，是无法接水的
            while (right >= 0 && height[right] - i <= 0) {
                right--;
            }
            for (int j = left; j <= right; j++) {
                if (height[j] - i <= 0) {   //只有小于等于0才有一个盛水位
                    result++;
                }
            }
        }
        return result;
    }
}
