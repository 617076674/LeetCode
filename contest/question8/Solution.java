package contest.question8;

public class Solution {
    private int result = Integer.MIN_VALUE;

    private boolean[] choosed;

    public int maxSizeSlices(int[] slices) {
        choosed = new boolean[slices.length];
        dfs(slices, 0, 0);
        return result;
    }

    private void dfs(int[] slices, int sum, int count) {
        if (count == slices.length) {
            result = Math.max(result, sum);
            return;
        }
        for (int i = 0; i < slices.length; i++) {
            if (!choosed[i]) {
                choosed[i] = true;
                int j = i;
                while (choosed[(j + 1) % slices.length]) {
                    j++;
                }
                choosed[(j + 1) % slices.length] = true;
                int k = i;
                while (choosed[(k - 1 + slices.length) % slices.length]) {
                    k--;
                }
                choosed[(k - 1 + slices.length) % slices.length] = true;
                dfs(slices, sum + slices[i], count + 3);
                choosed[(k - 1 + slices.length) % slices.length] = false;
                choosed[(j + 1) % slices.length] = false;
                choosed[i] = false;
            }
        }
    }
}