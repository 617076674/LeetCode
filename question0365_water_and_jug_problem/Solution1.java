package question0365_water_and_jug_problem;

import java.util.*;

/**
 * 深搜。
 *
 * 在LeetCode中提交会超时。
 */
public class Solution1 {
    private Set<List<Integer>> set = new HashSet<>();   //记录已经出现过的状态

    public boolean canMeasureWater(int x, int y, int z) {
        return canMeasureWater(0, 0, x, y, z);
    }

    private boolean canMeasureWater(int nowX, int nowY, int x, int y, int z) {
        set.add(Arrays.asList(nowX, nowY));
        if (nowX == z || nowY == z || nowX + nowY == z) {
            return true;
        }
        //1、给x加满水
        if (!set.contains(Arrays.asList(x, nowY))) {
            if (canMeasureWater(x, nowY, x, y, z)) {
                return true;
            }
        }
        //2、给y加满水
        if (!set.contains(Arrays.asList(nowX, y))) {
            if (canMeasureWater(nowX, y, x, y, z)) {
                return true;
            }
        }
        //3、清空x的水
        if (!set.contains(Arrays.asList(0, nowY))) {
            if (canMeasureWater(0, nowY, x, y, z)) {
                return true;
            }
        }
        //4、清空y的水
        if (!set.contains(Arrays.asList(nowX, 0))) {
            if (canMeasureWater(nowX, 0, x, y, z)) {
                return true;
            }
        }
        //5、x给y倒水
        if (nowX + nowY >= y) {
            if (!set.contains(Arrays.asList(nowX + nowY - y, y))) {
                if (canMeasureWater(nowX + nowY - y, y, x, y, z)) {
                    return true;
                }
            }
        } else {
            if (!set.contains(Arrays.asList(0, nowX + nowY))) {
                if (canMeasureWater(0, nowX + nowY, x, y, z)) {
                    return true;
                }
            }
        }
        //6、y给x倒水
        if (nowX + nowY >= x) {
            if (!set.contains(Arrays.asList(x, nowX + nowY - x))) {
                if (canMeasureWater(x, nowX + nowY - x, x, y, z)) {
                    return true;
                }
            }
        } else {
            if (!set.contains(Arrays.asList(nowX + nowY, 0))) {
                if (canMeasureWater(nowX + nowY, 0, x, y, z)) {
                    return true;
                }
            }
        }
        return false;
    }
}