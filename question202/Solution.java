package question202;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(n);
        while(n > 1) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            while(n > 0) {
                arrayList.add(n % 10);
                n /= 10;
            }
            n = 0;
            for (int integer : arrayList) {
                n += integer * integer;
            }
            if(hashSet.contains(n)) {
                return false;
            }else {
                hashSet.add(n);
            }
        }
        return true;
    }
}
