package question1146_snapshot_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SnapshotArray {

  private List<TreeMap<Integer, Integer>> arr = new ArrayList<>();

  private int snap;

  public SnapshotArray(int length) {
    for (int i = 0; i < length; i++) {
      arr.add(new TreeMap<>());
    }
  }

  public void set(int index, int val) {
    arr.get(index).put(snap, val);
  }

  public int snap() {
    return snap++;
  }

  public int get(int index, int snap_id) {
    Map.Entry<Integer, Integer> entry = arr.get(index).floorEntry(snap_id);
    return entry == null ? 0 : entry.getValue();
  }

}