package question069;

public class Solution3 {
    public int mySqrt(int x) {
        double pre = 0, cur = 1;
        while (Math.abs(pre - cur) >= 0.000001) {
            pre = cur;
            cur = (x + cur * cur) / (2 * cur);
        }
        return (int) pre;
    }

}
