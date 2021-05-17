package question1600_throne_inheritance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThroneInheritance {

  private String kingName;

  private Map<String, List<String>> map = new HashMap<>();

  private Set<String> deathSet = new HashSet<>();

  public ThroneInheritance(String kingName) {
    this.kingName = kingName;
    map.put(kingName, new ArrayList<>());
  }

  public void birth(String parentName, String childName) {
    map.get(parentName).add(childName);
    map.put(childName, new ArrayList<>());
  }

  public void death(String name) {
    deathSet.add(name);
  }

  public List<String> getInheritanceOrder() {
    List<String> result = new ArrayList<>();
    preOrderTraversal(result, kingName);
    return result;
  }

  private void preOrderTraversal(List<String> result, String name) {
    if (!deathSet.contains(name)) {
      result.add(name);
    }
    for (String child : map.get(name)) {
      preOrderTraversal(result, child);
    }
  }

}