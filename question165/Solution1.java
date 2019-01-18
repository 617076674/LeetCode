package question165;

import java.util.ArrayList;

public class Solution1 {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> arrayList1 = changeToArray(version1);
        ArrayList<Integer> arrayList2 = changeToArray(version2);
        for(int i = 0; i < arrayList1.size() || i < arrayList2.size(); i++){
            int num1 = 0, num2 = 0;
            if(i < arrayList1.size() && i < arrayList2.size()){
                num1 = arrayList1.get(i);
                num2 = arrayList2.get(i);
            }else if(i < arrayList1.size() && i >= arrayList2.size()){
                num1 = arrayList1.get(i);
            }else if(i >= arrayList1.size() && i < arrayList2.size()){
                num2 = arrayList2.get(i);
            }
            if(num1 > num2){
                return 1;
            }else if(num1 < num2){
                return -1;
            }
        }
        return 0;
    }
    private ArrayList<Integer> changeToArray(String version){
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] strings = version.split("\\.");
        for(String string : strings){
            arrayList.add(Integer.parseInt(string));
        }
        return arrayList;
    }
}
