package question216;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> retListList = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        generateCombination(new ArrayList<>(), 0, k, n);
        return retListList;
    }

    private void generateCombination(List<Integer> list, int sum, int k, int n) {
        if (list.size() == k && sum == n) {
            retListList.add(new ArrayList<>(list));
            return;
        }
        if (list.size() > k || sum > n) {
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (list.isEmpty() || i > list.get(list.size() - 1)) {
                list.add(i);
                generateCombination(list, sum + i, k, n);
                list.remove(list.size() - 1);
            }
        }
    }
}
