package question739;

public class Solution2 {

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] result = new int[n];
        result[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (T[i] == T[i + 1]) {
                if (result[i + 1] == 0) {
                    result[i] = 0;
                } else {
                    result[i] = result[i + 1] + 1;
                }
            } else if (T[i] < T[i + 1]) {
                result[i] = 1;
            } else {
                for (int j = i + 1 + result[i + 1]; j < n; j++) {
                    if (T[i] < T[j]) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }

}
