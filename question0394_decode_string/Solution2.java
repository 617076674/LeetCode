package question0394_decode_string;

/**
 * 递归实现。
 *
 * 时间复杂度和空间复杂度均是 O(n)，其中 n 为字符串 s 的长度。
 *
 * 执行用时：0ms，击败100.00%。消耗内存：37.7MB，击败7.69%。
 */
public class Solution2 {
    private int i;

    public String decodeString(String s) {
        return decode(s).toString();
    }

    private StringBuilder decode(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (c >= '0' && c <= '9') {
                count *= 10;
                count += c - '0';
            } else if (c == '[') {
                StringBuilder sb = decode(s);
                for (int j = 0; j < count; j++) {
                    result.append(sb);
                }
                count = 0;
            } else if (c == ']') {
                return result;
            } else {
                result.append(c);
            }
        }
        return result;
    }
}