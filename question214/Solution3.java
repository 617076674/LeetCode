package question214;

public class Solution3 {
    public String shortestPalindrome(String s) {
        String rev = reverse(s);
        String temp = s + "#" + rev;
        int[] next = getNext(temp);
        return rev.substring(0, rev.length() - next[temp.length() - 1]) + s;
    }
    private String reverse(String s){
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }
    private int[] getNext(String s){
        int[] result = new int[s.length()];
        result[0] = 0;
        for(int i = 1; i < result.length; i++){
            int temp = result[i - 1];
            while(temp > 0 && s.charAt(i) != s.charAt(temp)){
                temp = result[temp - 1];
            }
            if(s.charAt(i) == s.charAt(temp)){
                temp++;
            }
            result[i] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().shortestPalindrome("aacecaaa"));
    }
}
