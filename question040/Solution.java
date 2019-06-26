package question040;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82655956
 */
public class Solution {

    private List<List<Integer>> listList;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        listList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            addToMap(hashMap, candidates[i]);
        }
        combinationSum2(hashMap, target, new ArrayList<>(), 0);
        return listList;
    }

    private void combinationSum2(HashMap<Integer, Integer> hashMap, int target, List<Integer> list, int sum) {
        if (sum >= target) {
            if (sum == target) {
                listList.add(new ArrayList<>(list));
            }
            return;
        }
        HashMap<Integer, Integer> temp = new HashMap<>(hashMap);
        if (list.size() == 0) {
            for (Integer key : hashMap.keySet()) {
                list.add(key);
                removeFromMap(temp, key);
                combinationSum2(temp, target, list, sum + key);
                list.remove(list.size() - 1);
                addToMap(temp, key);
            }
        } else {
            for (Integer key : hashMap.keySet()) {
                if (key >= list.get(list.size() - 1)) {
                    list.add(key);
                    removeFromMap(temp, key);
                    combinationSum2(temp, target, list, sum + key);
                    list.remove(list.size() - 1);
                    addToMap(temp, key);
                }
            }
        }
    }

    private void addToMap(HashMap<Integer, Integer> hashMap, int element) {
        if (hashMap.containsKey(element)) {
            hashMap.put(element, hashMap.get(element) + 1);
        } else {
            hashMap.put(element, 1);
        }
    }

    private void removeFromMap(HashMap<Integer, Integer> hashMap, int element) {
        hashMap.put(element, hashMap.get(element) - 1);
        if (hashMap.get(element) == 0) {
            hashMap.remove(element);
        }
    }
}
