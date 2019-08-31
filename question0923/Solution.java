package question0923;

import java.util.Arrays;

/**
 * 三指针。
 *
 * 时间复杂度是O(n ^ 2)，其中n为数组A的长度。空间复杂度是O(1)。
 *
 * 执行用时：117ms，击败22.95%。消耗内存：39MB，击败80.00%。
 */
public class Solution {
    public int threeSumMulti(int[] A, int target) {
        int n;
        if (A == null || (n = A.length) < 3) {
            return 0;
        }
        Arrays.sort(A);
        int result = 0, mod = 1000000007;
        for (int i = 0; i < n - 2; i++) {
            if (A[i] > target) {
                break;
            }
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = A[i] + A[left] + A[right];
                if (sum == target) {
                    if (A[left] == A[right]) {  //因为数组有序，如果A[left] == A[right]，说明[left, right]中的数均相等
                        //假设[left, right]为[3, 3, 3]，显然取2个数的索引组合有3种。
                        result += (right - left) * (right - left + 1) / 2;
                        result %= mod;
                        break;  //因为[left, right]的数均相等，无需再移动左右指针继续判断
                    } else {
                        //进到这里，说明A[left] != A[right]，比如[2, 2, 3, 5, 5]，加入2和5满足要求，那么组合有2 * 2 = 4种
                        int tmpLeft = left;
                        while (left + 1 < right && A[left] == A[left + 1]) {
                            left++;
                        }
                        int tempRight = right;
                        while (right - 1 > left && A[right] == A[right - 1]) {
                            right--;
                        }
                        result += (left - tmpLeft + 1) * (tempRight - right + 1);
                        result %= mod;
                        left++;
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
