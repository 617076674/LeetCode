package question0914_x_of_a_kind_in_a_deck_of_cards;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希表 + 欧几里得最大公约数算法
 *
 * 时间复杂度是O(max(m, (log(n1) + log(n2) + ... + log(nk))))，其中m是deck数组的长度，
 * n1、n2、...、nk分别是deck数组中某个数出现的次数。空间复杂度是O(m)。
 *
 * 执行用时：5ms，击败80.72%。消耗内存：38.7MB，击败91.28%。
 */
public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int n;
        if (null == deck || (n = deck.length) < 2) {
            return false;
        }
        int[] map = new int[10000];
        for (int num : deck) {
            map[num]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : map) {
            if (num != 0) {
                set.add(num);
            }
        }
        if (set.size() == 1) {
            for (int num : set) {
                if (num != 1) {
                    return true;
                }
                return false;
            }
        }
        int result = -1;
        for (int num : set) {
            if (result != -1) {
                result = gcd(result, num);
            } else {
                result = num;
            }
        }
        return result != 1;
    }

    /**
     * 欧几里得最大公约数算法
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
