package question0067_add_binary;

/**
 * https://leetcode-cn.com/problems/add-binary/
 *
 * 时间复杂度是O(max(na, nb))，其中na是字符串a的长度，nb是字符串b的长度。
 *
 * 执行用时：4ms，击败27.60%。消耗内存：42.4MB，击败5.01%。
 */
public class Solution {
    public String addBinary(String a, String b) {
        int na = a.length(), nb = b.length(), flag = 0, i = na - 1, j = nb - 1;
        StringBuilder result = new StringBuilder();
        for (; i >= 0 && j >= 0; i--, j--) {
            int num = a.charAt(i) - '0' + b.charAt(j) - '0' + flag;
            if (num >= 2) {
                num -= 2;
                flag = 1;
            } else {
                flag = 0;
            }
            result.insert(0, num);
        }
        if (i != -1) {
            for (; i >= 0; i--) {
                int num = a.charAt(i) - '0' + flag;
                if (num >= 2) {
                    num -= 2;
                    flag = 1;
                } else {
                    flag = 0;
                }
                result.insert(0, num);
            }
        } else if (j != -1) {
            for (; j >= 0; j--) {
                int num = b.charAt(j) - '0' + flag;
                if (num >= 2) {
                    num -= 2;
                    flag = 1;
                } else {
                    flag = 0;
                }
                result.insert(0, num);
            }
        }
        if (flag == 1) {
            return result.insert(0, 1).toString();
        }
        return result.toString();
    }
}