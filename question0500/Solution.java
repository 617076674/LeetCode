package question0500;

import java.util.ArrayList;
import java.util.List;

/**
 * 哈希表。
 *
 * 时间复杂度是O(len)，其中len为words数组中的总字符数。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败98.92%。消耗内存：35.9MB，击败72.05%。
 */
public class Solution {
    private int[] map = new int[26];

    {
        map['Q' - 'A'] = 1;
        map['W' - 'A'] = 1;
        map['E' - 'A'] = 1;
        map['R' - 'A'] = 1;
        map['T' - 'A'] = 1;
        map['Y' - 'A'] = 1;
        map['U' - 'A'] = 1;
        map['I' - 'A'] = 1;
        map['O' - 'A'] = 1;
        map['P' - 'A'] = 1;

        map[0] = 2;
        map['S' - 'A'] = 2;
        map['D' - 'A'] = 2;
        map['F' - 'A'] = 2;
        map['G' - 'A'] = 2;
        map['H' - 'A'] = 2;
        map['J' - 'A'] = 2;
        map['K' - 'A'] = 2;
        map['L' - 'A'] = 2;

        map['Z' - 'A'] = 3;
        map['X' - 'A'] = 3;
        map['C' - 'A'] = 3;
        map['V' - 'A'] = 3;
        map['B' - 'A'] = 3;
        map['N' - 'A'] = 3;
        map['M' - 'A'] = 3;
    }

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String s : words) {
            if (judge(s)) {
                list.add(s);
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private boolean judge(String s) {
        int n;
        if (null == s || (n = s.length()) == 0) {
            return true;
        }
        int flag = getFlag(s.charAt(0));
        for (int i = 1; i < n; i++) {
            if (getFlag(s.charAt(i)) != flag) {
                return false;
            }
        }
        return true;
    }

    private int getFlag(char c) {
        if (c >= 'a' && c <= 'z') {
            return map[c - 'a'];
        }
        return map[c - 'A'];
    }
}
