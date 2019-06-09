package question074;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82904673
 */
public class Solution2 {

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
            array[i] = matrix[i][n - 1];
        }
        int row = ceil(array,target);
        if(row == m){
            return false;
        }
        return binarySearch(matrix[row], target);
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

    private int ceil(int[] array, int target){
        int left = 0;
        int right = array.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(array[mid] < target) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if(right - 1 >= 0 && array[right - 1] == target){
            return right - 1;
        }else{
            return right;
        }
    }

}
