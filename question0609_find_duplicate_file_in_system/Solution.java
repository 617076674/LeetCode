package question0609_find_duplicate_file_in_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> map = new HashMap<>();
    for (String path : paths) {
      String[] dirAndFiles = path.split(" ");
      String dir = dirAndFiles[0];
        for (int i = 1; i < dirAndFiles.length; i++) {
            String file = dirAndFiles[i];
            int index = file.indexOf('(');
            String content = file.substring(index, file.length() - 1);
            String dirAndFile = dir + "/" + file.substring(0, index);
            List<String> list = map.get(content);
            if (null == list) {
                List<String> tempList = new ArrayList<>();
                tempList.add(dirAndFile);
                map.put(content, tempList);
            } else {
                list.add(dirAndFile);
            }
        }
    }
    List<List<String>> result = new ArrayList<>();
    for (List<String> list : map.values()) {
        if (list.size() > 1) {
            result.add(list);
        }
    }
    return result;
  }

}