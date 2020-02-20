package question1010_pairs_of_songs_with_total_durations_divisible_by_60;

/**
 * 时间复杂度是O(n)，其中n是time数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败100.00%。消耗内存：43.1MB，击败7.68%。
 */
public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n;
        if (null == time || (n = time.length) == 0) {
            return 0;
        }
        int[] count = new int[60];  //统计time中各元素对60取余数的值的个数
        for (int i = 0; i < n; i++) {
            count[time[i] % 60]++;
        }
        int result = 0;
        //对于余数是0和余数是30的情况需要做特殊处理
        //当time = [30, 30, 30]时，可选择的对数为3 = 3 * 2 / 2。
        result += ((count[0] * (count[0] - 1)) >> 1) + ((count[30] * (count[30] - 1)) >> 1);
        //计算余数[1, 29]的情况，不计算余数[31, 59]是为了避免重复计算，因为如果一个余数在[1, 29]之间，另一个余数一定在[31, 59]之间
        for (int i = 1; i < 30; i++) {
            result += count[i] * (count[60 - i]);
        }
        return result;
    }
}