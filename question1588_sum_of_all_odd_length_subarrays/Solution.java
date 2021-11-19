package question1588_sum_of_all_odd_length_subarrays;

public class Solution {

    public int sumOddLengthSubarrays(int[] arr) {
        int[] sums = new int[arr.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + arr[i - 1];
        }
        int result = 0;
        for (int len = 1; len <= arr.length; len += 2) {
            for (int i = 0; i + len - 1 < arr.length; i++) {
                // [i, i + len - 1]
                result += sums[i + len] - sums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        System.out.println(new Solution().sumOddLengthSubarrays(arr));
    }

}