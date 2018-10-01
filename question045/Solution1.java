package question045;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82751536
 */
//backtracking
public class Solution1 {
	
	int steps;

	public int jump(int[] nums) {
        int n = nums.length;
        steps = n - 1;
        
        jump(nums, 0, 0);
        
        return steps;
    }
	
	/*
	 * Now I'm in the indexth position of nums, I have take tempSteps steps
	 */
	private void jump(int[] nums, int index, int tempSteps) {
		if(index >= nums.length - 1) {
			if(index == nums.length - 1) {
				steps = Math.min(steps, tempSteps);
			}
			return;
		}
		for (int i = 1; i <= nums[index]; i++) {
			jump(nums, index + i, tempSteps + 1);
		}
	}
}
