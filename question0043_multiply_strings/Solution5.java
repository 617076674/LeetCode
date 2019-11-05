package question0043_multiply_strings;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82710845
 */
public class Solution5 {

    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if (n1 == 1 && Integer.parseInt(num1) == 0) {
            return num1;
        }
        if (n2 == 1 && Integer.parseInt(num2) == 0) {
            return num2;
        }
        int[] nums = new int[n1 + n2];
        String result = "";
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                nums[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int flag = 0;
        for (int i = n1 + n2 - 2; i >= 0; i--) {
            result = (nums[i] + flag) % 10 + result;
            flag = (nums[i] + flag) / 10;
        }
        if (flag > 0) {
            result = flag + result;
        }
        return result;
    }
}
