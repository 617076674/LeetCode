package question097;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83309328
 */
import java.util.ArrayList;

public class Solution1 {

    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1, s2, s3, 0);
    }

    private boolean isInterleave(String s1, String s2, String s3, int index){
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if(n1 + n2 != n3){
            return false;
        }
        if(s1.length() == 0){
            return s2.equals(s3);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = index; i < n3; i++){
            if(s1.charAt(0) == s3.charAt(i)){
                arrayList.add(i);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if(isInterleave(s1.substring(1), s2, s3.substring(0, arrayList.get(i)) + s3.substring(arrayList.get(i) + 1), arrayList.get(i))){
                return true;
            }
        }
        return false;
    }
}
