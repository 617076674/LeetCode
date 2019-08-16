package question0495;

/**
 * @author qianyihui
 * @date 2019-08-16
 *
 * 每一轮新的攻击都会更新剩余冻结时长。
 *
 * 因此，对于[0, n - 2]的攻击，每次攻击的有效冻结时长是min(duration, timeSeries[i + 1] - timeSeries[i])
 *
 * 最后一次攻击的冻结时长是duration。
 *
 * 时间复杂度是O(n)，其中n为timeSeries数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：5ms，击败79.93%。消耗内存：53.7MB，击败5.33%。
 */
public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (duration == 0) {
            return 0;
        }
        int n;
        if (null == timeSeries || (n = timeSeries.length) == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            result += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        return result + duration;
    }
}
