package question0415_add_strings;

/**
 * 模拟字符串加法。
 *
 * 时间复杂度和空间复杂度均是O(max(n1, n2))，其中n1为字符串num1的长度，n2为字符串num2的长度。
 *
 * 执行用时：4ms，击败97.55%。消耗内存：35.9MB，击败87.87%。
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int flag = 0, index1 = num1.length() - 1, index2 = num2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 >= 0 && index2 < 0) {
                int num = num1.charAt(index1) - '0' + flag;
                if (num >= 10) {
                    num -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                sb.append(num);
                index1--;
            } else if (index1 < 0) {
                int num = num2.charAt(index2) - '0' + flag;
                if (num >= 10) {
                    num -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                sb.append(num);
                index2--;
            } else {
                int num = num1.charAt(index1) - '0' + num2.charAt(index2) - '0' + flag;
                if (num >= 10) {
                    num -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                sb.append(num);
                index1--;
                index2--;
            }
        }
        if (flag != 0) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }
}