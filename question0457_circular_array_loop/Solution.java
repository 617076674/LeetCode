package question0457_circular_array_loop;

/**
 * 本质是dfs算法，将遍历过的点设置为大于1000的值，避免重复遍历。
 *
 * 时间复杂度是O(n)，其中n为nums数组的长度。空间复杂度是O(1)。
 *
 * 执行用时：1ms，击败100.00%。消耗内存：35.5MB，击败48.00%。
 */
public class Solution {

    public boolean circularArrayLoop(int[] nums) {
        if (nums == null) {
            return false;
        }
        int round = 1000;   //用来标记是否是同一个循环中的点
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 1000) {
                continue;
            }
            boolean negative = nums[i] < 0;
            int length = 1, next = findNext(nums, i);
            nums[i] = ++round;  //如果是本次循环中的点，均将其标记为round + 1
            while (nums[next] <= 1000 && nums[next] != round && (nums[next] > 0 ^ negative)) {
                int temp = next;
                next = findNext(nums, next);
                if (temp == next) { //如果next点和tmp点相同，即自环
                    length = 1;
                    break;
                }
                nums[temp] = round;
                length++;
            }
            if (nums[next] == round && length > 1) {
                return true;
            }
        }
        return false;
    }

    private int findNext(int[] nums, int i) {
        int n = nums.length;
        int next = (i + nums[i]) % n;
        if (next < 0) {
            next += n;
        }
        return next;
    }

}
