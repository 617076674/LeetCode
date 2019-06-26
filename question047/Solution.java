package question047;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82766873
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    List<List<Integer>> listList;

    public List<List<Integer>> permuteUnique(int[] nums) {
        listList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            addToHashMap(hashMap, nums[i]);
        }
        permuteUnique(hashMap, new ArrayList<>());
        return listList;
    }

    //we put the possible array in list, we are going to find next number
    private void permuteUnique(HashMap<Integer, Integer> hashMap, List<Integer> list) {
        if (hashMap.isEmpty()) {
            listList.add(new ArrayList<>(list));
            return;
        }
        HashMap<Integer, Integer> tempHashMap = new HashMap<>(hashMap);
        for (Integer integer : hashMap.keySet()) {
            list.add(integer);
            delFromHashMap(tempHashMap, integer);
            permuteUnique(tempHashMap, list);
            addToHashMap(tempHashMap, integer);
            list.remove(list.size() - 1);
        }
    }

    private void addToHashMap(HashMap<Integer, Integer> hashMap, int num) {
        if (hashMap.containsKey(num)) {
            hashMap.put(num, hashMap.get(num) + 1);
        } else {
            hashMap.put(num, 1);
        }
    }

    private void delFromHashMap(HashMap<Integer, Integer> hashMap, int num) {
        hashMap.put(num, hashMap.get(num) - 1);
        if (hashMap.get(num) == 0) {
            hashMap.remove(num);
        }
    }
}
