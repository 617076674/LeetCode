package question0009;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行用时：54ms，击败54.07%。消耗内存：38.6MB，击败84.85%。
 */
public class Solution2 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }
        for (int i = 0; i <= list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
