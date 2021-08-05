package question0770_basic_calculator_iv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  private static class Poly {

    Map<List<String>, Integer> count = new HashMap<>();

    void update(List<String> key, int val) {
      this.count.put(key, this.count.getOrDefault(key, 0) + val);
    }

    Poly add(Poly that) {
      Poly ans = new Poly();
      for (List<String> k : this.count.keySet()) {
        ans.update(k, this.count.get(k));
      }
      for (List<String> k : that.count.keySet()) {
        ans.update(k, that.count.get(k));
      }
      return ans;
    }

    Poly sub(Poly that) {
      Poly ans = new Poly();
      for (List<String> k : this.count.keySet()) {
        ans.update(k, this.count.get(k));
      }
      for (List<String> k : that.count.keySet()) {
        ans.update(k, -that.count.get(k));
      }
      return ans;
    }

    Poly mul(Poly that) {
      Poly ans = new Poly();
      for (List<String> k1 : this.count.keySet()) {
        for (List<String> k2 : that.count.keySet()) {
          List<String> kNew = new ArrayList<>();
          kNew.addAll(k1);
          kNew.addAll(k2);
          Collections.sort(kNew);
          ans.update(kNew, this.count.get(k1) * that.count.get(k2));
        }
      }
      return ans;
    }

    Poly evaluate(Map<String, Integer> evalMap) {
      Poly ans = new Poly();
      for (List<String> k : this.count.keySet()) {
        int c = this.count.get(k);
        List<String> free = new ArrayList<>();
        for (String token : k) {
          if (evalMap.containsKey(token)) {
            c *= evalMap.get(token);
          } else {
            free.add(token);
          }
        }
        ans.update(free, c);
      }
      return ans;
    }

    int compareList(List<String> A, List<String> B) {
      int i = 0;
      for (String x : A) {
        String y = B.get(i++);
        if (x.compareTo(y) != 0) {
          return x.compareTo(y);
        }
      }
      return 0;
    }

    List<String> toList() {
      List<String> ans = new ArrayList<>();
      List<List<String>> keys = new ArrayList<>(this.count.keySet());
      Collections.sort(keys, (a, b) ->
          a.size() != b.size() ? b.size() - a.size() : compareList(a, b));

      for (List<String> key : keys) {
        int v = this.count.get(key);
        if (v == 0) {
          continue;
        }
        StringBuilder word = new StringBuilder();
        word.append(v);
        for (String token : key) {
          word.append('*');
          word.append(token);
        }
        ans.add(word.toString());
      }
      return ans;
    }
  }

  public List<String> basicCalculatorIV(String expression, String[] evalVars, int[] evalInts) {
    Map<String, Integer> evalMap = new HashMap<>();
    for (int i = 0; i < evalVars.length; ++i) {
      evalMap.put(evalVars[i], evalInts[i]);
    }
    return parse(expression).evaluate(evalMap).toList();
  }

  public Poly make(String expr) {
    Poly ans = new Poly();
    List<String> list = new ArrayList<>();
    if (Character.isDigit(expr.charAt(0))) {
      ans.update(list, Integer.parseInt(expr));
    } else {
      list.add(expr);
      ans.update(list, 1);
    }
    return ans;
  }

  public Poly combine(Poly left, Poly right, char symbol) {
    if (symbol == '+') {
      return left.add(right);
    }
    if (symbol == '-') {
      return left.sub(right);
    }
    if (symbol == '*') {
      return left.mul(right);
    }
    throw null;
  }

  public Poly parse(String expr) {
    List<Poly> bucket = new ArrayList<>();
    List<Character> symbols = new ArrayList<>();
    int i = 0;
    while (i < expr.length()) {
      if (expr.charAt(i) == '(') {
        int bal = 0, j = i;
        for (; j < expr.length(); ++j) {
          if (expr.charAt(j) == '(') {
            bal++;
          }
          if (expr.charAt(j) == ')') {
            bal--;
          }
          if (bal == 0) {
            break;
          }
        }
        bucket.add(parse(expr.substring(i + 1, j)));
        i = j;
      } else if (Character.isLetterOrDigit(expr.charAt(i))) {
        int j = i;
        search:
        {
          for (; j < expr.length(); ++j) {
            if (expr.charAt(j) == ' ') {
              bucket.add(make(expr.substring(i, j)));
              break search;
            }
          }
          bucket.add(make(expr.substring(i)));
        }
        i = j;
      } else if (expr.charAt(i) != ' ') {
        symbols.add(expr.charAt(i));
      }
      i++;
    }
    for (int j = symbols.size() - 1; j >= 0; --j) {
      if (symbols.get(j) == '*') {
        bucket.set(j, combine(bucket.get(j), bucket.remove(j + 1), symbols.remove(j)));
      }
    }
    if (bucket.isEmpty()) {
      return new Poly();
    }
    Poly ans = bucket.get(0);
    for (int j = 0; j < symbols.size(); ++j) {
      ans = combine(ans, bucket.get(j + 1), symbols.get(j));
    }
    return ans;
  }

}