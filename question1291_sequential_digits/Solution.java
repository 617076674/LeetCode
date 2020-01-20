package question1291_sequential_digits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 递归生成所有符合条件的数字，再排序即可。
 *
 * 时间复杂度和空间复杂度均是O(log(high))。
 *
 * 执行用时：1ms，击败64.35%。消耗内存：33.7MB，击败100.00%。
 */
public class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> sequentialDigits(int low, int high) {
        generateNumbers(0, low, high);
        Collections.sort(result);
        return result;
    }

    private void generateNumbers(int num, int low, int high) {
        if (num > high) {
            return;
        }
        if (num >= low && num <= high) {
            result.add(num);
        }
        if (num == 0) {
            for (int i = 1; i <= 9; i++) {
                generateNumbers(i, low, high);
            }
        } else if (num % 10 < 9) {
            generateNumbers(num * 10 + num % 10 + 1, low, high);
        }
    }
}