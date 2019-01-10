package question140;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<String> result = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        nextWord(s, wordDict, 0, "");
        return result;
    }
    private void nextWord(String s, List<String> wordDict, int index, String tempString){
        if(index == s.length()){
            result.add(tempString);
            return;
        }
        for(String str : wordDict){
            if(s.substring(index).startsWith(str)){
                if(0 == tempString.length()){
                    nextWord(s, wordDict, index + str.length(), s.substring(index, index + str.length()));
                }else{
                    nextWord(s, wordDict, index + str.length(), tempString + " " + s.substring(index, index + str.length()));
                }
            }
        }
    }
    private boolean include(String string, List<String> wordDict) {
        for (String s : wordDict) {
            if(s.equals(string)) {
                return true;
            }
        }
        return false;
    }
}