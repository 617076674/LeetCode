package question0686_repeated_string_match;

/**
 * 首先判断字符串A的长度n1和字符串B的长度n2的大小关系，分为下面2种情况：
 * （1）n1 >= n2，如果A中包含了B，直接返回1。如果(A + A)中包含了B，直接返回2。否则，返回-1。
 * （2）n1 < n2，在(A + A)中寻找B.substring(0, n1)字符串的匹配位置，开始循环匹配。
 */
public class Solution {
    public int repeatedStringMatch(String A, String B) {
        int n1 = A.length(), n2 = B.length(), result = 0, index1 = 0, index2 = 0;
        String tmp = A + A;
        if (n1 >= n2) {
            if (A.contains(B)) {
                return 1;
            }
            if (tmp.contains(B)) {
                return 2;
            }
            return -1;
        } else {
            index1 = tmp.indexOf(B.substring(0, n1));
            if (index1 == -1) {
                return -1;
            }
            while (index2 < n2) {
                if (A.charAt(index1) == B.charAt(index2)) {
                    index1++;
                    if (index1 >= n1) {
                        result++;
                        index1 = 0;
                    }
                    index2++;
                } else {
                    return -1;
                }
            }
            if (index1 != 0) {
                result++;
            }
            return result;
        }
    }
}