package question0009;

/**
 * 将反转后得到的数字和原数字比较是否相等。这里不用考虑数据溢出问题，如果溢出，显然就不相等了。
 * <p>
 * 执行用时：50ms，击败66.56%。消耗内存：37.6MB，击败87.01%。
 */
public class Solution4 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x <= 9) {
            return true;
        }
        int reverse = 0, temp = x;
        while (temp > 0) {
            reverse = reverse * 10 + temp % 10;
            temp = temp / 10;
        }
        return reverse == x;
    }
}
