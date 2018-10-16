package question081;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82955777
 */
public class Solution {

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target == nums[left]){
                return true;
            }else if(target < nums[left]){
                if(target == nums[mid]){
                    return true;
                }else if(target < nums[mid]){
                    int[] leftRight = search(nums, left, mid, right, target);
                    left = leftRight[0];
                    right = leftRight[1];
                }else{
                    left = mid + 1;
                }
            }else{
                if(target == nums[mid]){
                    return true;
                }else if(target < nums[mid]){
                    right = mid - 1;
                }else{
                    int[] leftRight = search(nums, left, mid, right, target);
                    left = leftRight[0];
                    right = leftRight[1];
                }
            }
        }
        return false;
    }

    private int[] search(int[] nums, int left, int mid, int right, int target){
        if(nums[mid] > nums[left]) {
            left = mid + 1;
        }else if(nums[mid] < nums[left]){
            right = mid - 1;
        }else{
            int i = left;
            for (; i <= mid; i++) {
                if(nums[i] != nums[mid]){
                    break;
                }
            }
            if(i <= mid){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        int[] result = new int[2];
        result[0] = left;
        result[1] = right;
        return result;
    }
}
