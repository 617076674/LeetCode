package question0341_flatten_nested_list_iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

  private LinkedList<Integer> linkedList = new LinkedList<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    flatten(nestedList);
  }

  private void flatten(List<NestedInteger> nestedList) {
    for (NestedInteger nestedInteger : nestedList) {
      if (nestedInteger.isInteger()) {
        linkedList.addLast(nestedInteger.getInteger());
      } else {
        flatten(nestedInteger.getList());
      }
    }
  }

  @Override
  public Integer next() {
    return linkedList.pollFirst();
  }

  @Override
  public boolean hasNext() {
    return !linkedList.isEmpty();
  }

}