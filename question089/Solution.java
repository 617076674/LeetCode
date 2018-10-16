package question089;

/*
 * See analysis: https://blog.csdn.net/qq_41231926/article/details/83054471
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<Integer> retList;

    public List<Integer> grayCode(int n) {
        retList = new ArrayList<>();
        retList.add(0);
        if(n == 0){
            return retList;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("0");
        }
        grayCode(retList, stringBuilder, n);
        return retList;
    }

    private void grayCode(List<Integer> list, StringBuilder stringBuilder, int n){
        if(list.size() == Math.pow(2, n)){
            retList = new ArrayList<>(list);
            return;
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            if(retList.size() == Math.pow(2, n)){
                break;
            }
            if(stringBuilder.charAt(i) == '0'){
                stringBuilder.replace(i, i + 1, "1");
                int num = Integer.parseInt(stringBuilder.toString(), 2);
                if(!list.contains(num)){
                    list.add(num);
                    grayCode(list, stringBuilder, n);
                    list.remove(list.size() - 1);
                }
                stringBuilder.replace(i, i + 1, "0");
            }else{
                stringBuilder.replace(i, i + 1, "0");
                int num = Integer.parseInt(stringBuilder.toString(), 2);
                if(!list.contains(num)){
                    list.add(num);
                    grayCode(list, stringBuilder, n);
                    list.remove(list.size() - 1);
                }
                stringBuilder.replace(i, i + 1, "1");
            }
        }
    }
}
