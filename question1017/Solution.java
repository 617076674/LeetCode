package question1017;

/**
 * @author qianyihui
 * @date 2019-07-24
 *
 * 辗转相除法。
 *
 * 执行用时：3ms，击败56.76%。消耗内存：35MB，击败69.64%。
 */
public class Solution {
    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while (N != 0) {
            int tmp = N % (-2);
            N /= -2;
            if (tmp < 0) {
                tmp += 2;
                N += 1;
            }
            result.append(tmp);
        }
        return result.reverse().toString();
    }
}
