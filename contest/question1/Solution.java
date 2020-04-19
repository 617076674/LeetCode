package contest.question1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String reformat(String s) {
        List<Character> listNumber = new ArrayList<>(), listLetter = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                listNumber.add(c);
            } else {
                listLetter.add(c);
            }
        }
        if (Math.abs(listNumber.size() - listLetter.size()) > 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index1 = 0, index2 = 0;
        while (index1 < listNumber.size() || index2 < listLetter.size()) {
            if (listNumber.size() >= listLetter.size()) {
                if (index1 < listNumber.size()) {
                    sb.append(listNumber.get(index1++));
                }
                if (index2 < listLetter.size()) {
                    sb.append(listLetter.get(index2++));
                }
            } else {
                if (index2 < listLetter.size()) {
                    sb.append(listLetter.get(index2++));
                }
                if (index1 < listNumber.size()) {
                    sb.append(listNumber.get(index1++));
                }
            }
        }
        return sb.toString();
    }
}