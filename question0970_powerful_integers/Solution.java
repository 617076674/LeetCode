package question0970_powerful_integers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 注意对x = 1和y = 1的情况做特殊处理。
 *
 * 执行用时：2ms，击败95.79%。消耗内存：33.9MB，击败79.33%。
 */
public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        if (x == 1) {
            if (y == 1) {
                if (2 <= bound) {
                    set.add(2);
                    return new ArrayList<>(set);
                }
                return new ArrayList<>();
            }
            return powerfulIntegers(y, x, bound);
        }
        int limit1 = (int) (Math.log(bound - 1) / Math.log(x));
        if (y == 1) {
            for (int i = 0; i <= limit1; i++) {
                int tmp = (int) (Math.pow(x, i) + 1);
                if (tmp <= bound) {
                    set.add(tmp);
                } else {
                    break;
                }
            }
            return new ArrayList<>(set);
        }
        for (int i = 0; i <= limit1; i++) {
            for (int j = 0; ; j++) {
                int tmp = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (tmp <= bound) {
                    set.add(tmp);
                } else {
                    break;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
