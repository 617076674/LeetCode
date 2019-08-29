package question1093;

/**
 * 时间复杂度和空间复杂度均是O(1)。
 *
 * 执行用时：2ms，击败79.72%。消耗内存：36.8MB，击败100.00%。
 */
public class Solution {
    public double[] sampleStats(int[] count) {
        double[] result = new double[5];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, majority = 0, n = 0;
        double sum = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
                sum += count[i] * i;
                if (count[i] > count[majority]) {
                    majority = i;
                }
                n += count[i];
            }
        }
        result[0] = min;
        result[1] = max;
        result[2] = sum / n;
        result[4] = majority;
        int num = findKth(count, (n + 1) >> 1);
        if ((n & 1) == 0) {
            int num2 = findKth(count, (n >> 1) + 1);
            result[3] = (num + num2) / 2.0;
        } else {
            result[3] = num;
        }
        return result;
    }

    private int findKth(int[] count, int k) {
        int sum = 0;
        for (int i = 0; i < 256; i++) {
            sum += count[i];
            if (sum >= k) {
                return i;
            }
        }
        return -1;
    }
}
