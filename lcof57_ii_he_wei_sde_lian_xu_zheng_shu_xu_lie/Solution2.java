package lcof57_ii_he_wei_sde_lian_xu_zheng_shu_xu_lie;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> listList = new ArrayList<>();
        if (target <= 1) {
            return null;
        }
        int left = 1, right = 2, sum = 3, mid = (target + 1) >> 1;
        while (left < mid) {
            if (sum == target) {
                addToResult(left, right, listList);
            }
            while (sum > target && left < mid) {
                sum -= left;
                left++;
                if (sum == target) {
                    addToResult(left, right, listList);
                }
            }
            right++;
            sum += right;
        }
        int[][] result = new int[listList.size()][];
        for (int i = 0; i < listList.size(); i++) {
            int[] nums = new int[listList.get(i).size()];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = listList.get(i).get(j);
            }
            result[i] = nums;
        }
        return result;
    }

    private void addToResult(int left, int right, List<List<Integer>> listList) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            list.add(i);
        }
        listList.add(list);
    }
}