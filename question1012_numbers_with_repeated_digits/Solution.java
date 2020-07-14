package question1012_numbers_with_repeated_digits;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/numbers-with-repeated-digits/solution/zui-kuai-zui-qing-xi-de-jie-fa-by-woodnote/
 *
 * 执行用时：1ms，击败98.90%。消耗内存：36.4MB，击败100.00%。
 */
public class Solution {
    public int numDupDigitsAtMostN(int N) {
        return N - numNoDupDigitsAtMostN(N);
    }

    public int numNoDupDigitsAtMostN(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        int k = digits.size();
        int[] used = new int[10];
        int total = 0;
        for (int i = 1; i < k; i++) {
            total += 9 * A(9, i - 1);
        }
        for (int i = k - 1; i >= 0; i--) {
            int num = digits.get(i);
            for (int j = (i == k - 1 ? 1 : 0); j < num; j++) {
                if (used[j] != 0) {
                    continue;
                }
                total += A(10 - (k - i), i);
            }
            if (++used[num] > 1) {
                break;
            }
            if (i == 0) {
                total++;
            }
        }
        return total;
    }

    public int fact(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    // 剩下可填入的数字有 m 个，还需要填写的位数是 n 位，可构成的不含重复位的数字个数
    public int A(int m, int n) {
        return fact(m) / fact(m - n);
    }
}