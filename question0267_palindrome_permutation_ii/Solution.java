package question0267_palindrome_permutation_ii;

import java.util.*;

/**
 * 先生成回文串的一半，再附加上另一半即可。
 *
 * 如何生成回文串的一半？见question0047——全排列II。
 *
 * 时间复杂度是O(n!)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：5ms，击败51.81%。消耗内存：36.2MB，击败100.00%。
 */
public class Solution {
    private Map<Character, Integer> map = new HashMap<>();

    private Map<Character, Integer> halfMap = new HashMap<>();

    private int n;

    private List<String> list = new ArrayList<>();

    private StringBuilder sb = new StringBuilder();

    private char oddCharacter;

    private int odd;

    public List<String> generatePalindromes(String s) {
        n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for(char c : map.keySet()) {
            if ((map.get(c) & 1) == 1) {
                odd++;
                oddCharacter = c;
                if (map.get(c) > 1) {
                    halfMap.put(c, (map.get(c) - 1) >> 1);
                }
            } else {
                halfMap.put(c, map.get(c) >> 1);
            }
        }
        if (odd > 1) {
            return new ArrayList<>();
        }
        permuteUnique();
        return list;
    }

    private void permuteUnique() {
        if (halfMap.isEmpty()) {
            if (odd == 1) {
                list.add(sb.toString() + oddCharacter + sb.reverse().toString());
            } else {
                list.add(sb.toString() + sb.reverse().toString());
            }
            sb.reverse();
            return;
        }
        for (char c : new HashSet<>(halfMap.keySet())) {
            sb.append(c);
            delFromHashMap(halfMap, c);
            permuteUnique();
            addToHashMap(halfMap, c);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private void addToHashMap(Map<Character, Integer> map, char c) {
        if (map.containsKey(c)) {
            map.put(c, map.get(c) + 1);
        } else {
            map.put(c, 1);
        }
    }

    private void delFromHashMap(Map<Character, Integer> map, char c) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) {
            map.remove(c);
        }
    }
}