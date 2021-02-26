package question0995_minimum_number_of_k_consecutive_bit_flips;

/**
 * 对同一个子数组执行两次翻转操作不会改变该子数组，所以对每个长度为K的子数组，应至多执行一次翻转操作。
 *
 * 对于若干个K位翻转操作，改变先后顺序并不影响最终翻转的结果。从A[0]开始考虑，若A[0] == 0，则必定要翻转从位置0开始的
 * 子数组，若A[0] == 1，则不翻转从位置0开始的子数组。
 *
 * 按照这一策略，从左到右地执行这些翻转操作。由于翻转操作是唯一的，若最终数组元素均为1，则执行的翻转次数就是最小的。
 *
 * 差分数组：
 * diff[i]表示两个相邻元素A[i-1]和A[i]的翻转次数的差，对于区间[left, right]，将其元素全部加1，只会影响到left和
 * right + 1处的差分值，故diff[left]增加1，diff[right+1]减少1。
 *
 * 通过累加差分数组可以得到当前位置需要翻转的次数，用变量sumDiff来表示。
 */
public class Solution1 {

    public int minKBitFlips(int[] A, int K) {
        int result = 0, sumDiff = 0;
        int[] diff = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            sumDiff += diff[i];
            if ((A[i] + sumDiff) % 2 == 0) {
                if (i + K > A.length) {
                    return -1;
                }
                result++;
                sumDiff++;
                diff[i + K]--;
            }
        }
        return result;
    }

}