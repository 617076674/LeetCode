package question069;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82861877
 */
public class Solution1 {

    public int mySqrt(int x) {
        for (long i = 1; i <= x; i++) {
            if (i * i > x) {
                return (int) (i - 1);
            } else if (i * i == x) {
                return (int) i;
            }
        }
        return 0;
    }
}
