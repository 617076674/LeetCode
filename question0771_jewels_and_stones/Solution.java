package question0771_jewels_and_stones;

import java.util.HashSet;
import java.util.Set;

/**
 * 执行用时：2ms，击败47.74%。消耗内存：37.2MB，击败57.13%。
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                result++;
            }
        }
        return result;
    }
}