package question165;

public class Solution2 {
    public int compareVersion(String version1, String version2) {
        int index1 = 0, index2 = 0;
        while(index1 < version1.length() || index2 < version2.length()){
            int num1 = 0, num2 = 0;
            if(index1 < version1.length() && index2 < version2.length()){
                num1 = getNextNum(version1, index1);
                num2 = getNextNum(version2, index2);
                int temp1 = version1.substring(index1).indexOf(".");
                if(temp1 != -1) {
                    index1 += temp1 + 1;
                }else{
                    index1 = version1.length();
                }
                int temp2 = version2.substring(index2).indexOf(".");
                if(temp2 != -1) {
                    index2 += temp2 + 1;
                }else{
                    index2 = version2.length();
                }
            }else if(index1 < version1.length() && index2 >= version2.length()){
                num1 = getNextNum(version1, index1);
                int temp1 = version1.substring(index1).indexOf(".");
                if(temp1 != -1) {
                    index1 += temp1 + 1;
                }else{
                    index1 = version1.length();
                }
            }else if(index1 >= version1.length() && index2 < version2.length()){
                num2 = getNextNum(version2, index2);
                int temp2 = version2.substring(index2).indexOf(".");
                if(temp2 != -1) {
                    index2 += temp2 + 1;
                }else{
                    index2 = version2.length();
                }
            }
            if(num1 > num2){
                return 1;
            }else if(num1 < num2){
                return -1;
            }
        }
        return 0;
    }
    private int getNextNum(String version, int index){
        if(version.substring(index).indexOf(".") == -1){
            return Integer.parseInt(version.substring(index));
        }
        return Integer.parseInt(version.substring(index, version.substring(index).indexOf(".") + index));
    }
}
