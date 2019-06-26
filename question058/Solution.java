package question058;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82820156
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int i = n - 1;
        while (s.charAt(i) == ' ') {
            i--;
            if (i < 0) {
                return 0;
            }
        }
        int start = i;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
        }
        return start - i;
    }
}
