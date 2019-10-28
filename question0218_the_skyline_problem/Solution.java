package question0218_the_skyline_problem;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/the-skyline-problem/solution/218tian-ji-xian-wen-ti-sao-miao-xian-fa-by-ivan_al/
 *
 * 扫描线法。
 *
 * 执行用时：84ms，击败47.96%。消耗内存：43.5MB，击败95.19%。
 */
public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int[] build : buildings) {
            //插入左节点
            if (!map.containsKey(build[0])) {
                map.put(build[0], new ArrayList<>());
            }
            map.get(build[0]).add(-build[2]);   //负数表示是左端点的高度，很精髓！
            //插入右节点
            if (!map.containsKey(build[1])) {
                map.put(build[1], new ArrayList<>());
            }
            map.get(build[1]).add(build[2]);    //正数表示是右端点的高度
        }
        //保留当前位置的所有高度 重定义排序：从大到小
        Map<Integer, Integer> heights = new TreeMap<>((o1, o2) -> o2 - o1);
        int last = 0;    //保留上一个位置的高度
        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            Collections.sort(list);
            for (int y : list) {
                //左端点,高度入队
                if (y < 0) {
                    if (heights.containsKey(-y)) {
                        heights.put(-y, heights.get(-y) + 1);
                    } else {
                        heights.put(-y, 1);
                    }
                } else {
                    //右端点移除高度
                    heights.put(y, heights.get(y) - 1);
                    if (heights.get(y) == 0) {
                        heights.remove(y);
                    }
                }
                //获取heights的最大值:就是第一个值
                int maxHeight = 0;
                if (!heights.isEmpty()) {
                    maxHeight = heights.keySet().iterator().next();
                }
                //如果当前最大高度不同于上一个高度，说明其为转折点
                if (last != maxHeight) {
                    //更新last，并加入结果集
                    last = maxHeight;
                    result.add(Arrays.asList(key, maxHeight));
                }
            }
        }
        return result;
    }
}