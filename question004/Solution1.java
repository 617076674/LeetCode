package question004;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/81805795
 */
public class Solution1 {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		int i = 0;
		int j = 0;
		int[] array = new int[(n1 + n2) / 2 + 1];
		int index = 0;
		while(index < array.length) {
			if(i < n1 && j < n2) {
				if(nums1[i] < nums2[j]) {
					array[index] = nums1[i];
					i++;
				}else {
					array[index] = nums2[j];
					j++;
				}
			}else if(i >= n1 && j < n2) {
				array[index] = nums2[j];
				j++;
			}else if(i < n1 && j >= n2) {
				array[index] = nums1[i];
				i++;
			}
			index++;
		}
		if((n1 + n2) % 2 == 0) {
			return 0.5 * (array[array.length - 1] + array[array.length - 2]); 
		}else {
			return array[array.length - 1];
		}
	}
}
