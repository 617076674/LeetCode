package question1993_operations_on_tree;

import java.util.HashSet;
import java.util.Set;

public class LockingTree {

  private Set<Integer>[] children;

  private int[] num2User;

  private int[] parent;

  public LockingTree(int[] parent) {
    children = new HashSet[parent.length];
    for (int i = 0; i < children.length; i++) {
      children[i] = new HashSet<>();
    }
    for (int i = 1; i < parent.length; i++) {
      int cur = i;
      children[parent[cur]].add(i);
      while (parent[cur] != -1) {
        children[parent[cur]].addAll(children[cur]);
        cur = parent[cur];
      }
    }
    num2User = new int[parent.length];
    this.parent = parent;
  }

  public boolean lock(int num, int user) {
    if (num2User[num] > 0) {
      return false;
    }
    num2User[num] = user;
    return true;
  }

  public boolean unlock(int num, int user) {
    if (num2User[num] != user) {
      return false;
    }
    num2User[num] = 0;
    return true;
  }

  public boolean upgrade(int num, int user) {
    if (num2User[num] > 0) {
      return false;
    }
    int cur = num;
    while (cur != -1) {
      if (num2User[cur] > 0) {
        return false;
      }
      cur = parent[cur];
    }
    boolean hasLockedChild = false;
    for (int child : children[num]) {
      if (num2User[child] > 0) {
        hasLockedChild = true;
        break;
      }
    }
    if (!hasLockedChild) {
      return false;
    }
    num2User[num] = user;
    for (int child : children[num]) {
      num2User[child] = 0;
    }
    return true;
  }

  //["LockingTree","lock","unlock","unlock","lock","upgrade","lock"]
  //[[[-1,0,0,1,1,2,2]],[2,2],[2,3],[2,2],[4,5],[0,1],[0,1]]
  public static void main(String[] args) {
    int[] parent = {-1, 0,0,1,1,2,2};
    LockingTree lockingTree = new LockingTree(parent);
    System.out.println(lockingTree.lock(2,2));
    System.out.println(lockingTree.unlock(2,3));
    System.out.println(lockingTree.unlock(2,2));
    System.out.println(lockingTree.lock(4,5));
    System.out.println(lockingTree.upgrade(0,1));
    System.out.println(lockingTree.lock(0,1));
  }

}