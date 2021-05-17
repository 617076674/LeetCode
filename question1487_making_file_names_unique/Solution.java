package question1487_making_file_names_unique;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public String[] getFolderNames(String[] names) {
    Map<String, Integer> map2Index = new HashMap<>();
    String[] result = new String[names.length];
    for (int i = 0; i < names.length; i++) {
        if (map2Index.containsKey(names[i])) {
            for (int k = map2Index.get(names[i]) + 1; ; k++) {
                String newName = names[i] + "(" + k + ")";
                if (!map2Index.containsKey(newName)) {
                    result[i] = newName;
                    map2Index.put(names[i], k);
                    map2Index.put(newName, 0);
                    break;
                }
            }
        } else {
            result[i] = names[i];
            map2Index.put(names[i], 0);
        }
    }
    return result;
  }

}