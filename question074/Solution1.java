package question074;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82904673
 */
public class Solution1 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0){
            return false;
        }
        int n = matrix[0].length;
        if(n == 0){
            return false;
        }
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = matrix[i][0];
        }
        int row = floor(array,target);
        if(row == -1){
            return false;
        }
        return binarySearch(matrix[row],target);
    }

    private boolean binarySearch(int[] array, int target){
        int left = 0, right = array.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(array[mid] == target){
                return true;
            }else if(array[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }

    private int floor(int[] array, int target){
        int left = -1;
        int right = array.length - 1;
        while(left < right){
            int mid = left + (right - left + 1) / 2;
            if(array[mid] < target) {
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        if(left + 1 < array.length && array[left + 1] == target){
            return left + 1;
        }else{
            return left;
        }
    }

}
