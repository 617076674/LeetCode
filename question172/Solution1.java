package question172;

public class Solution1 {
    public int trailingZeroes(int n) {
        int result = 0;
        if (n == 0) {
            return result;
        }
        String factorial = factorial(1, n);
        for (int i = factorial.length() - 1; i >= 0; i--) {
            if (factorial.charAt(i) == '0') {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    private String factorial(int left, int right) {
        if (left == right) {
            return String.valueOf(left);
        }
        int mid = left + (right - left) / 2;
        return multiply(factorial(left, mid), factorial(mid + 1, right));
    }

    private String multiply(String num1, String num2) {
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
