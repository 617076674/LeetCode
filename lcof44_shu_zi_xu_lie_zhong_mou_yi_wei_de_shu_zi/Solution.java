package lcof44_shu_zi_xu_lie_zhong_mou_yi_wei_de_shu_zi;

public class Solution {

    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }
        int num = 2;    // n 所在的数字属于一个 num 位数
        int begin = 10, end = 189;
        while (n > end) {
            begin = end + 1;
            end = (int) (begin + 9 * Math.pow(10, num) * (num + 1) - 1);
            num++;
        }
        int index = (n - begin) / num;
        int numContainsN = (int) (index + Math.pow(10, num - 1));
        return String.valueOf(numContainsN).charAt(n - index * num - begin) - '0';
    }

}