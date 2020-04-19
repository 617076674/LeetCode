package question0466_count_the_repetitions;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度是O(len1 * len2)，其中len1为字符串s1的长度，len2为字符串s2的长度。空间复杂度是O(len2)。
 *
 * 执行用时：5ms，击败78.05%。消耗内存：37.2MB，击败100.00%。
 */
public class Solution2 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }
        int len1 = s1.length(), len2 = s2.length(), num1 = 0, num2 = 0, index2 = 0;
        Map<Integer, Pair<Integer, Integer>> map = new HashMap<>();
        Pair<Integer, Integer> preLoop, inLoop;
        while (true) {
            num1++;
            for (int i = 0; i < len1; i++) {
                char c = s1.charAt(i);
                if (c == s2.charAt(index2)) {
                    index2++;
                    if (index2 == len2) {
                        num2++;
                        index2 = 0;
                    }
                }
            }
            if (num1 == n1) {
                return num2 / n2;
            }
            if (map.containsKey(index2)) {
                preLoop = map.get(index2);
                inLoop = new Pair<>(num1 - preLoop.getKey(), num2 - preLoop.getValue());
                break;
            } else {
                map.put(index2, new Pair<>(num1, num2));
            }
        }
        int result = preLoop.getValue() + (n1 - preLoop.getKey()) / inLoop.getKey() * inLoop.getValue();
        int reserved = (n1 - preLoop.getKey()) % inLoop.getKey();
        for (int i = 0; i < reserved; i++) {
            for (int j = 0; j < len1; j++) {
                char c = s1.charAt(j);
                if (c == s2.charAt(index2)) {
                    index2++;
                    if (index2 == len2) {
                        result++;
                        index2 = 0;
                    }
                }
            }
        }
        return result / n2;
    }
}
