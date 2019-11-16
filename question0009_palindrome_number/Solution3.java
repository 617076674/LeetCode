package question0009_palindrome_number;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * 将反转后得到的数字和原数字比较是否相等。这里不用考虑数据溢出问题，如果溢出，显然就不相等了。
 *
 * 执行用时：50ms，击败66.56%。消耗内存：37.6MB，击败87.01%。
 */
public class Solution3 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x <= 9) {
            return true;
        }
        int reverse = 0, tmp = x;
        while (tmp > 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp /= 10;
        }
        return reverse == x;
    }
}