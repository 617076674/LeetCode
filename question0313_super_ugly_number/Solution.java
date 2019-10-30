package question0313_super_ugly_number;

import java.util.Arrays;

/**
 * 和question0264同样的解法。
 *
 * 时间复杂度是O(n * len)，其中len是primes数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：17ms，击败86.32%。消耗内存：35.5MB，击败43.82%。
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] superUglies = new int[n];
        superUglies[0] = 1;
        Arrays.sort(primes);
        int[] indexes = new int[len];
        for (int i = 1; i < n; i++) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                tmp = Math.min(superUglies[indexes[j]] * primes[j], tmp);
            }
            for (int j = 0; j < len; j++) {
                if (tmp == superUglies[indexes[j]] * primes[j]) {
                    superUglies[i] = tmp;
                    indexes[j]++;
                }
            }
        }
        return superUglies[n - 1];
    }
}