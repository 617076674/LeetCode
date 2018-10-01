package question045;

public class Solution3 {
	
	//greedy algorithm
	public int jump(int[] nums) {
        int n = nums.length;
        int steps = 0;
        int index = 0;
        while(index < n - 1) {
        	steps++;
        	int[] lengths = new int[nums[index]];
        	if(index + nums[index] >= n - 1) {
        		break;
        	}
        	for (int i = index + 1; i <= index + nums[index]; i++) {
				lengths[i - index - 1] = i + nums[i];
			}
        	int max = 0;
        	for (int i = 0; i < lengths.length; i++) {
				if(lengths[i] > lengths[max]) {
					max = i;
				}
			}
        	index = max + index + 1;
        }
        return steps;
    }
}
