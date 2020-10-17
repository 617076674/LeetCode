package question1601_maximum_number_of_achievable_transfer_requests;

/**
 * 暴力破解法。
 *
 * 时间复杂度是 O((m + n) * 2 ^ m)，其中 m 为 requests 数组的长度。空间复杂度是 O(n)。
 *
 * 执行用时：144ms，击败27.15%。消耗内存：39MB，击败19.16%。
 */
public class Solution {

    public int maximumRequests(int n, int[][] requests) {
        int result = 0;
        for (int status = 0; status < (1 << requests.length); status++) {
            int[] degrees = new int[n];
            for (int i = 0; i < requests.length; i++) {
                if ((status & (1 << i)) != 0) {
                    degrees[requests[i][0]]--;
                    degrees[requests[i][1]]++;
                }
            }
            boolean flag = true;
            for (int degree : degrees) {
                if (degree != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                int tmp = 0;
                for (int i = 0; i < 32; i++) {
                    if (((status >> i) & 1) == 1) {
                        tmp++;
                    }
                }
                result = Math.max(result, tmp);
            }
        }
        return result;
    }

}