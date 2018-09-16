package question042;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82682179
 */
public class Solution1 {
	
	public int trap(int[] height) {
		int n = height.length;
		int result = 0;
		if(n == 0) {
            return result;
        }
        int maxHeight = height[0];
        for (int i = 1; i < n; i++) {
			if(height[i] > maxHeight) {
				maxHeight = height[i];
			}
		}
        int[] newHeight = new int[n];
        for (int i = 0; i < maxHeight; i++) {
			for (int j = 0; j < n; j++) {
				newHeight[j] = height[j] - i;
			}
			int left = 0;
			int right = n - 1;
			while(left < n && newHeight[left] <= 0) {
				left++;
			}
			while(right >= 0 && newHeight[right] <= 0) {
				right--;
			}
			for (int j = left; j <= right; j++) {
				if(newHeight[j] <= 0) {
					result++;
				}
			}
		}
        return result;
    }
}
