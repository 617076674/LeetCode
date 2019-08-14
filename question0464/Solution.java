package question0464;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qianyihui
 * @date 2019-08-14
 *
 * 记忆化搜索。
 *
 * 时间复杂度和空间复杂度均是O(maxChoosableInteger ^ 2)。
 *
 * 执行用时：126ms，击败65.94%。消耗内存：50.5MB，击败65.22%。
 */
public class Solution {
    private Map<Integer, Boolean> map = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //desiredTotal小于等于maxChoosableInteger，必赢
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        //如果所有和加起来都不到desiredTotal，直接返回false
        if ((maxChoosableInteger + 1) * (maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        return dfs(0, maxChoosableInteger, desiredTotal);
    }

    //state记录[1, maxChooseableInteger]范围内的哪些数字被使用过了，目标是desiredTotal
    //如果state为 00000000 00000000 00000000 00001000，则说明数字3被使用过了
    private boolean dfs(int state, int maxChoosableInteger, int desiredTotal) {
        if (map.containsKey(state)) {
            return map.get(state);
        }
        boolean result = false;
        for (int num = maxChoosableInteger; num >= 1; num--) {
            if (used(state, num)) {    //如果这个num已经被使用过了，不考虑
                continue;
            }
            if (num >= desiredTotal) {
                result = true;
            } else {
                result = !dfs(state | (1 << num), maxChoosableInteger, desiredTotal - num);
            }
            if (result) {
                break;
            }
        }
        map.put(state, result);
        return result;
    }

    //如果num是1，则将当前状态右移1位，并和1与运算，如果结果是1，说明该num已经被使用过了
    private boolean used(int state, int num) {
        return ((state >> num) & 1) == 1;
    }
}
