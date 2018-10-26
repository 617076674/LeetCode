package question096;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83276409
 */
public class Solution2 {

    public int numTrees(int n) {
        if(n == 1){
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(i == 1 || i == n){
                count += numTrees(n - 1);
            }else{
                count += numTrees(i - 1) * numTrees(n - i);
            }
        }
        return count;
    }
}
