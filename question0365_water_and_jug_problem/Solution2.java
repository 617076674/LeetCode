package question0365_water_and_jug_problem;

import java.util.*;

/**
 * 广搜。
 *
 * 执行用时：617ms，击败5.16%。消耗内存：155.8MB，击败5.26%。
 */
public class Solution2 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return x == z || y == z;
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();   //记录已经出现过的状态
        List<Integer> list = Arrays.asList(0, 0);
        queue.add(list);
        set.add(list);
        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            int nowX = now.get(0), nowY = now.get(1);
            if (z == nowX || z == nowY || z == nowX + nowY) {
                return true;
            }
            //1、给x加满水
            List<Integer> list1 = Arrays.asList(x, nowY);
            if (!set.contains(list1)) {
                set.add(list1);
                queue.add(list1);
            }
            //2、给y加满水
            List<Integer> list2 = Arrays.asList(nowX, y);
            if (!set.contains(list2)) {
                set.add(list2);
                queue.add(list2);
            }
            //3、清空x的水
            List<Integer> list3 = Arrays.asList(0, nowY);
            if (!set.contains(list3)) {
                set.add(list3);
                queue.add(list3);
            }
            //4、清空y的水
            List<Integer> list4 = Arrays.asList(nowX, 0);
            if (!set.contains(list4)) {
                set.add(list4);
                queue.add(list4);
            }
            //5、x给y倒水
            List<Integer> list5 = (nowX + nowY >= y) ? Arrays.asList(nowX + nowY - y, y) : Arrays.asList(0, nowX + nowY);
            if (!set.contains(list5)) {
                set.add(list5);
                queue.add(list5);
            }
            //6、y给x倒水
            List<Integer> list6 = (nowX + nowY >= x) ? Arrays.asList(x, nowX + nowY - x) : Arrays.asList(nowX + nowY, 0);
            if (!set.contains(list6)) {
                set.add(list6);
                queue.add(list6);
            }
        }
        return false;
    }
}