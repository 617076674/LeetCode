package lcof58_ii_zuo_xuan_zhuan_zi_fu_chuan;

public class Solution {

    public String reverseLeftWords(String s, int n) {
        return (s + s).substring(n, n + s.length());
    }

}