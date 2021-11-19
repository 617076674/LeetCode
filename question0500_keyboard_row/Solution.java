package question0500_keyboard_row;

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
        map[16] = 1;
        map[22] = 1;
        map[4] = 1;
        map[17] = 1;
        map[19] = 1;
        map[24] = 1;
        map[20] = 1;
        map[8] = 1;
        map[14] = 1;
        map[15] = 1;

        map[0] = 2;
        map[18] = 2;
        map[3] = 2;
        map[5] = 2;
        map[6] = 2;
        map[7] = 2;
        map[9] = 2;
        map[10] = 2;
        map[11] = 2;

        map[25] = 3;
        map[23] = 3;
        map[2] = 3;
        map[21] = 3;
        map[1] = 3;
        map[13] = 3;
        map[12] = 3;
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