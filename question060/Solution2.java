package question060;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82834088
 */
public class Solution2 {

	public String getPermutation(int n, int k) {
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		getPermutation(array, 0, k);
		String result = "";
		for (int i = 0; i < array.length; i++) {
			result += array[i];
		}
		return result;
	}
	
	private void getPermutation(int[] array, int index, int k) {
		if(k == 1) {
			return;
		}
		int i = index;
		int level = factorial(array.length - index - 1);
		for (; i < array.length; i++) {
			if(k - level < 1) {
				break;
			}
			k -= level;
		}
		int temp = array[i];
		for (int j = i - 1; j >= index; j--) {
			array[j + 1] = array[j];
		}
		array[index] = temp;
		getPermutation(array, index + 1, k);
	}

	//to calculate factorial of n
	private int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
