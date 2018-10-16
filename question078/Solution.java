package question078;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82935378
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<List<Integer>> listList;

    public List<List<Integer>> subsets(int[] nums) {
        listList = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subSets(nums, new ArrayList<>(), i);
        }
        return listList;
    }

    private void subSets(int[] nums, List<Integer> list, int n){
        if(list.size() == n){
            listList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i]) || (!list.isEmpty() && list.get(list.size() - 1) > nums[i])){
                continue;
            }
            list.add(nums[i]);
            subSets(nums, list, n);
            list.remove(list.size() - 1);
        }
    }
}
