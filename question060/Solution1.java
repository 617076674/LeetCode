package question060;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/82834088
 */
import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	
	List<String> list;

	public String getPermutation(int n, int k) {
        list = new ArrayList<>();
        getPermutationUp("", 0, n, k);
        return list.get(k - 1);
    }
	
	//string consists of index numbers, we are going to consider the index + 1 number
	private void getPermutationUp(String string, int index, int n, int k) {
		if(index == n) {
			list.add(string);
			return;
		}
		for (int i = 1; i <= n; i++) {
			if(string.indexOf('0' + i) == -1) {
				string += i;
				getPermutationUp(string, index + 1, n, k);
				string = string.substring(0, string.length() - 1);
			}
		}
	}
}
