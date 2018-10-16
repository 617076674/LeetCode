package question087;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83035336
 */
import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public boolean isScramble(String s1, String s2) {
        int n1 = s1.length();
        List<String>[][] lists = new List[n1][n1];
        for (int i = 0; i < n1; i++) {
            lists[i][i] = new ArrayList<String>();
            lists[i][i].add(s1.substring(i, i + 1));
        }
        for (int gap = -1; gap >= 1 - n1; gap--) {
            for (int i = 0; i - gap <= n1 - 1; i++) {
                lists[i][i - gap] = new ArrayList<String>();
                for (int k = i; k <= i - gap - 1; k++) {
                    List<String> list1 = lists[i][k];
                    List<String> list2 = lists[k + 1][i - gap];
                    for(String string1 : list1){
                        for(String string2 : list2){
                            if(!lists[i][i - gap].contains(string1 + string2)) {
                                lists[i][i - gap].add(string1 + string2);
                            }
                            if(!lists[i][i - gap].contains(string2 + string1)) {
                                lists[i][i - gap].add(string2 + string1);
                            }
                        }
                    }
                }
            }
        }
        if(lists[0][n1 - 1].contains(s2)){
            return true;
        }
        return false;
    }
}
