package question0047_permutations_ii;

import java.util.*;

/**
 * 将数组nums中的值存进一个map里，用回溯法求全排列。
 *
 * 时间复杂度是O(n!)，其中n为nums数组的长度。空间复杂度是O(n)。
 *
 * 执行用时：10ms，击败31.31%。消耗内存：37.7MB，击败97.14%。
 */
public class Solution {
    private List<List<Integer>> listList = new ArrayList<>();

    private Map<Integer, Integer> map = new HashMap<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            addToHashMap(map, nums[i]);
        }
        permuteUnique(new ArrayList<>());
        return listList;
    }

    //we put the possible array in list, we are going to find next number
    private void permuteUnique(List<Integer> list) {
        if (map.isEmpty()) {
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int num : new HashSet<>(map.keySet())) {
            list.add(num);
            delFromHashMap(map, num);
            permuteUnique(list);
            addToHashMap(map, num);
            list.remove(list.size() - 1);
        }
    }

    private void addToHashMap(Map<Integer, Integer> map, int num) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }

    private void delFromHashMap(Map<Integer, Integer> map, int num) {
        map.put(num, map.get(num) - 1);
        if (map.get(num) == 0) {
            map.remove(num);
        }
    }
}