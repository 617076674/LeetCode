package question0018_4sum;

import java.util.*;

/**
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82177660
 *
 * 时间复杂度是O(n ^ 3)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：410ms，击败5.06%。消耗内存：65.1MB，击败6.17%。
 */
public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        int n;
        if (null == nums || (n = nums.length) == 0) {
            return listList;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        // 4个数相同
        int quarter = target >> 2;
        if (target % 4 == 0 && map.containsKey(quarter) && map.get(quarter) >= 4) {
            addToListList(quarter, quarter, quarter, quarter, listList);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        // 3个数相同
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) * 3 + list.get(j) == target && map.get(list.get(i)) >= 3) {
                    addToListList(list.get(i), list.get(i), list.get(i), list.get(j), listList);
                }
                if (list.get(i) + list.get(j) * 3 == target && map.get(list.get(j)) >= 3) {
                    addToListList(list.get(i), list.get(j), list.get(j), list.get(j), listList);
                }
            }
        }
        // 2个数相同+2个数相同
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) * 2 + list.get(j) * 2 == target && map.get(list.get(i)) >= 2 && map.get(list.get(j)) >= 2) {
                    addToListList(list.get(i), list.get(i), list.get(j), list.get(j), listList);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    // 2个数相同+2个数不同
                    if ((list.get(i) << 1) + list.get(j) + list.get(k) == target && map.get(list.get(i)) >= 2) {
                        addToListList(list.get(i), list.get(i), list.get(j), list.get(k), listList);
                    }
                    if (list.get(i) + (list.get(j) << 1) + list.get(k) == target && map.get(list.get(j)) >= 2) {
                        addToListList(list.get(i), list.get(j), list.get(j), list.get(k), listList);
                    }
                    if (list.get(i) + list.get(j) + (list.get(k) << 1) == target && map.get(list.get(k)) >= 2) {
                        addToListList(list.get(i), list.get(j), list.get(k), list.get(k), listList);
                    }
                    // 4个数均不相同
                    int num = target - list.get(i) - list.get(j) - list.get(k);
                    if (num > list.get(k) && map.containsKey(num)) {
                        addToListList(list.get(i), list.get(j), list.get(k), num, listList);
                    }
                }
            }
        }
        return listList;
    }

    private void addToListList(int num1, int num2, int num3, int num4, List<List<Integer>> listList) {
        List<Integer> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        list.add(num4);
        listList.add(list);
    }
}