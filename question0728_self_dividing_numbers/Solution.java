package question0728_self_dividing_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间复杂度是O(n * log(n))，其中n为区间[left, right]中的元素数目。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败99.53%。消耗内存：33.8MB，击败76.59%。
 */
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSelfDividingNumber(int num) {
        int tmp = num;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || tmp % digit != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
