package question0470_implement_rand10_using_rand7;

/**
 * 执行用时：6ms，击败92.77%。消耗内存：47.5MB，击败5.64%。
 */
public class Solution extends SolBase {
    public int rand10() {
        while (true) {
            //num1在[1, 7]范围内，num2在[1, 7]范围内，num3在[1, 49]范围内
            int num1 = rand7(), num2 = rand7(), num3 = (num1 - 1) * 7 + num2;
            if (num3 >= 1 && num3 <= 40) {
                return 1 + (num3 - 1) % 10;
            }
            num3 -= 40;
            //此时num3在[1, 9]范围内，num4在[1, 7]范围内，num5在[1, 51]范围内
            int num4 = rand7(), num5 = (num4 - 1) * 7 + num3;
            if (num5 >= 1 && num5 <= 50) {
                return 1 + (num5 - 1) % 10;
            }
        }
    }
}