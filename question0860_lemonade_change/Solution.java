package question0860_lemonade_change;

/**
 * 当两张5元和1张10元可以选择使用时，尽量先使用1张使用。
 *
 * 时间复杂度是O(n)，其中n为bills数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：2ms，击败100.00%。消耗内存：39.8MB，击败92.47%。
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n;
        if (null == bills || (n = bills.length) == 0) {
            return true;
        }
        int count5 = 0, count10 = 0, count20 = 0;
        for (int i = 0; i < n; i++) {
            if (bills[i] == 5) {
                count5++;
            } else if (bills[i] == 10) {
                if (count5 == 0) {
                    return false;
                }
                count5--;
                count10++;
            } else {
                if (count10 == 0) {
                    if (count5 < 3) {
                        return false;
                    } else {
                        count5 -= 3;
                        count20++;
                    }
                } else {
                    if (count5 == 0) {
                        return false;
                    } else {
                        count5--;
                        count10--;
                        count20++;
                    }
                }
            }
        }
        return true;
    }
}
