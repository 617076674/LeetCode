package question0842_split_array_into_fibonacci_sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法。
 *
 * 时间复杂度是O(n!)，其中n是字符串S的长度。空间复杂度是O(n)。
 *
 * 执行用时：4ms，击败86.89%。消耗内存：35.9MB，击败85.71%。
 */
public class Solution {
    private List<Integer> result;

    public List<Integer> splitIntoFibonacci(String S) {
        splitIntoFibonacci(S, 0, new ArrayList<>());
        return null == result || result.size() < 3 ? new ArrayList<>() : result;
    }

    private void splitIntoFibonacci(String s, int index, List<Integer> list) {
        if (null != result) {
            return;
        }
        if (index == s.length()) {
            result = new ArrayList<>(list);
            return;
        }
        if (list.size() >= 2) {
            String num = String.valueOf(list.get(list.size() - 1) + list.get(list.size() - 2));
            if (s.substring(index).startsWith(num)) {
                list.add(Integer.valueOf(num));
                splitIntoFibonacci(s, index + num.length(), list);
                list.remove(list.size() - 1);
            }
        } else {
            if (s.charAt(index) == '0') {
                list.add(0);
                splitIntoFibonacci(s, index + 1, list);
                list.remove(list.size() - 1);
            } else {
                for (int i = index + 1; i < s.length(); i++) {
                    int num;
                    try {
                        num = Integer.valueOf(s.substring(index, i));
                    } catch (Exception e) {
                        break;
                    }
                    list.add(num);
                    splitIntoFibonacci(s, i, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}