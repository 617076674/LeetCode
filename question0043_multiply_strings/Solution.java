package question0043_multiply_strings;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 *
 * 时间复杂度是O(n1 * n2)，其中n1是字符串num1的长度，n2是字符串num2的长度。空间复杂度是O(n1 + n1)。
 *
 * 执行用时：5ms，击败85.12%。消耗内存：37MB，击败37.91%。
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        if (n1 == 1 && Integer.parseInt(num1) == 0) {
            return num1;
        }
        if (n2 == 1 && Integer.parseInt(num2) == 0) {
            return num2;
        }
        int[] nums = new int[n1 + n2 - 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                nums[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int flag = 0;
        for (int i = n1 + n2 - 2; i >= 0; i--) {
            sb.insert(0, (nums[i] + flag) % 10);
            flag = (nums[i] + flag) / 10;
        }
        if (flag > 0) {
            sb.insert(0, flag);
        }
        return sb.toString();
    }
}