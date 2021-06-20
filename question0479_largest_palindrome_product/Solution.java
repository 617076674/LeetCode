package question0479_largest_palindrome_product;

public class Solution {

    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int upper = (int) (Math.pow(10, n) - 1), lower = (int) Math.pow(10, n - 1);
        for (int i = upper; i >= lower; i--) {
            String s = String.valueOf(i);
            String reverseS = reverse(s);
            long num = Long.parseLong(s + reverseS);
            for (long j = upper; j * j >= num; j--) {
                if (num % j == 0) {
                    return (int) (num % 1337);
                }
            }
        }
        return -1;
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}