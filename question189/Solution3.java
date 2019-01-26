package question189;

public class Solution3 {
    public void rotate(int[] nums, int k) {
        if(0 == nums.length){
            return;
        }
        k %= nums.length;
        int count = 0;
        for(int start = 0; count < nums.length; start++){
            int current = start;
            int prev = nums[start];
            do{
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            }while (start != current);
        }
    }
}
