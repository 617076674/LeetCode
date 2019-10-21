package question0929_unique_email_addresses;

import java.util.HashSet;
import java.util.Set;

/**
 * 时间复杂度是O(n)，其中n为email数组中的每个字符串中@字符之前的字符数总和。空间复杂度是O(m)，其中m为经过转化后不同的邮件数。
 *
 * 执行用时：10ms，击败99.71%。消耗内存：38.7MB，击败97.32%。
 */
public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            set.add(change(s));
        }
        return set.size();
    }

    private String change(String s) {
        int index = s.indexOf('@');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            char c = s.charAt(i);
            if (c == '.') {
                continue;
            } else if (c == '+') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString() + s.substring(index);
    }
}
