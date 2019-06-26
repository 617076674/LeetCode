package question090;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83021650
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    private List<List<Integer>> listList;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        listList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            addToHashMap(hashMap, nums[i]);
        }
        for (int i = 0; i <= nums.length; i++) {
            subsetsWithDup(new ArrayList<>(), i, hashMap);
        }
        return listList;
    }

    private void subsetsWithDup(List<Integer> list, int n, HashMap<Integer, Integer> hashMap) {
        if (list.size() == n) {
            if (!listList.contains(list)) {
                listList.add(new ArrayList<>(list));
            }
            return;
        }
        HashMap<Integer, Integer> tempHashMap = new HashMap<>(hashMap);
        for (Integer temp : tempHashMap.keySet()) {
            if (!list.isEmpty() && list.get(list.size() - 1) > temp) {
                continue;
            }
            list.add(temp);
            delFromHashMap(hashMap, temp);
            subsetsWithDup(list, n, hashMap);
            addToHashMap(hashMap, temp);
            list.remove(list.get(list.size() - 1));
        }
    }

    private void addToHashMap(HashMap<Integer, Integer> hashMap, Integer temp) {
        if (hashMap.containsKey(temp)) {
            hashMap.put(temp, hashMap.get(temp) + 1);
        } else {
            hashMap.put(temp, 1);
        }
    }

    private void delFromHashMap(HashMap<Integer, Integer> hashMap, Integer temp) {
        hashMap.put(temp, hashMap.get(temp) - 1);
        if (hashMap.get(temp) == 0) {
            hashMap.remove(temp);
        }
    }
}
