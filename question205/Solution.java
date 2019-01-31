package question205;

import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(hashMap.containsKey(c)) {
                if(!hashMap.get(c).equals(t.charAt(i))) {
                    return false;
                }
            }else {
                hashMap.put(c, t.charAt(i));
            }
        }
        for (Character c1 : hashMap.keySet()) {
            for (Character c2 : hashMap.keySet()) {
                if(!c1.equals(c2) && hashMap.get(c1).equals(hashMap.get(c2))) {
                    return false;
                }
            }
        }
        return true;
    }
}
