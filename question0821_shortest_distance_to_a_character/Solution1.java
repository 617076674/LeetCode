package question0821_shortest_distance_to_a_character;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找法。
 *
 * 时间复杂度是O(nlogm)，其中n为字符串S的长度，m为字符串S中字符C的个数。空间复杂度是O(m)。
 *
 * 执行用时：6ms，击败35.56%。消耗内存：36.1MB，击败85.35%。
 */
public class Solution1 {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) {
                list.add(i);
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int index = floor(list, i);
            int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE, num3 = Integer.MAX_VALUE;
            if (index - 1 >= 0) {
                num1 = Math.abs(i - list.get(index - 1));
            }
            if (index >= 0 && index <= list.size() - 1) {
                num2 = Math.abs(i - list.get(index));
            }
            if (index + 1 <= list.size() - 1) {
                num3 = Math.abs(i - list.get(index + 1));
            }
            result[i] = Math.min(num1, Math.min(num2, num3));
        }
        return result;
    }

    private int floor(List<Integer> list, int target) {
        int left = -1, right = list.size() - 1;
        while (left < right) {
            int mid = left + ((right - left + 1) >> 1);
            if (list.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (left + 1 < list.size() && list.get(left + 1) == target) {
            return left + 1;
        }
        return left;
    }
}
