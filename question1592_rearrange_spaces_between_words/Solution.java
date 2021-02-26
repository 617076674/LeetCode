package question1592_rearrange_spaces_between_words;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String reorderSpaces(String text) {
        List<String> stringList = new ArrayList<>();
        StringBuilder tmpSb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (tmpSb.length() > 0) {
                    stringList.add(tmpSb.toString());
                    tmpSb = new StringBuilder();
                }
            } else {
                tmpSb.append(c);
            }
        }
        if (tmpSb.length() > 0) {
            stringList.add(tmpSb.toString());
        }
        int spaces = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                spaces++;
            }
        }
        if (stringList.size() == 1) {
            StringBuilder result = new StringBuilder();
            result.append(stringList.get(0));
            for (int i = 0; i < spaces; i++) {
                result.append(' ');
            }
            return result.toString();
        }
        int gap = stringList.size() - 1;
        int gapLen = spaces / gap;
        int remain = spaces - gapLen * gap;
        StringBuilder sb = new StringBuilder();
        sb.append(stringList.get(0));
        StringBuilder gapStringBuilder = new StringBuilder();
        for (int i = 0; i < gapLen; i++) {
            gapStringBuilder.append(' ');
        }
        for (int i = 1; i < stringList.size(); i++) {
            sb.append(gapStringBuilder);
            sb.append(stringList.get(i));
        }
        for (int i = 0; i < remain; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

}