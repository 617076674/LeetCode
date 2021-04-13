package question0981_time_based_key_value_store;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {

  private Map<String, TreeMap<Integer, String>> map = new HashMap<>();

  public TimeMap() {
  }

  public void set(String key, String value, int timestamp) {
    TreeMap<Integer, String> tree = map.get(key);
    if (null == tree) {
      tree = new TreeMap<>();
      tree.put(timestamp, value);
      map.put(key, tree);
    } else {
      tree.put(timestamp, value);
    }
  }

  public String get(String key, int timestamp) {
    TreeMap<Integer, String> tree = map.get(key);
    if (null == tree) {
      return "";
    }
    Map.Entry<Integer, String> t = tree.floorEntry(timestamp);
    return t == null ? "" : t.getValue();
  }

}