package question0895_maximum_frequency_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack {

  private Map<Integer, Integer> val2Freq = new HashMap<>();

  private Map<Integer, Stack<Integer>> group = new HashMap<>();

  private int maxFreq;

  public FreqStack() {

  }

  public void push(int x) {
    int freq = val2Freq.getOrDefault(x, 0) + 1;
    val2Freq.put(x, freq);
    if (freq > maxFreq) {
      maxFreq = freq;
    }
    group.computeIfAbsent(freq, z -> new Stack<>()).push(x);
  }

  public int pop() {
    int result = group.get(maxFreq).pop();
    val2Freq.put(result, val2Freq.get(result) - 1);
    if (group.get(maxFreq).isEmpty()) {
      maxFreq--;
    }
    return result;
  }

}