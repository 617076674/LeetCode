package question1215_stepping_numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 回溯+排序（注意数据越界）
 *
 * 执行用时：13ms，击败89.69%。消耗内存：37.1MB，击败100.00%。
 */
public class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> countSteppingNumbers(int low, int high) {
        countSteppingNumbers(0, low, high);
        Collections.sort(result);
        return result;
    }

    private void countSteppingNumbers(long now, int low, int high) {
        if (now > high) {
            return;
        }
        if (now >= low) {
            result.add((int) now);
        }
        if (now == 0) {
            for (int i = 1; i <= 9; i++) {
                countSteppingNumbers(now * 10 + i, low, high);
            }
        } else {
            int num = (int) now % 10;
            if (num - 1 >= 0) {
                countSteppingNumbers(now * 10 + num - 1, low, high);
            }
            if (num + 1 <= 9) {
                countSteppingNumbers(now * 10 + num + 1, low, high);
            }
        }
    }
}