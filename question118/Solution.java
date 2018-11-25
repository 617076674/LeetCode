package question118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new ArrayList<>();
        if(0 == numRows){
            return listList;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        listList.add(list);
        for(int i = 1; i < numRows; i++){
            List<Integer> nextList = new ArrayList<>();
            nextList.add(1);
            for(int j = 0; j < list.size() - 1; j++){
                nextList.add(list.get(j) + list.get(j + 1));
            }
            nextList.add(1);
            listList.add(nextList);
            list = new ArrayList<>(nextList);
        }
        return listList;
    }
}
