package question0843_guess_the_word;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  private int[][] matches;

  public void findSecretWord(String[] wordlist, Master master) {
    int n = wordlist.length;
    matches = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int match = 0;
        for (int k = 0; k < 6; k++) {
          if (wordlist[i].charAt(k) == wordlist[j].charAt(k)) {
            match++;
          }
        }
        matches[i][j] = matches[j][i] = match;
      }
    }

    List<Integer> possible = new ArrayList<>(), path = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      possible.add(i);
    }

    while (!possible.isEmpty()) {
      int guess = solve(possible, path);
      int matches = master.guess(wordlist[guess]);
      if (matches == wordlist[0].length()) {
        return;
      }
      List<Integer> possible2 = new ArrayList<>();
      for (Integer j : possible) {
        if (this.matches[guess][j] == matches) {
          possible2.add(j);
        }
      }
      possible = possible2;
      path.add(guess);
    }

  }

  /**
   * 选择的单词是让最多的与该单词有相同匹配的单词数最小
   */
  public int solve(List<Integer> possible, List<Integer> path) {
    if (possible.size() <= 2) {
      return possible.get(0);
    }
    List<Integer> ansgrp = possible;
    int ansguess = -1;

    for (int guess = 0; guess < matches.length; guess++) {
      if (!path.contains(guess)) {
        ArrayList<Integer>[] groups = new ArrayList[7];
        for (int i = 0; i < 7; ++i) {
          groups[i] = new ArrayList<>();
        }
        for (Integer j : possible) {
          if (j != guess) {
            groups[matches[guess][j]].add(j);
          }
        }

        ArrayList<Integer> maxgroup = groups[0];
        for (int i = 0; i < 7; ++i) {
          if (groups[i].size() > maxgroup.size()) {
            maxgroup = groups[i];
          }
        }

        if (maxgroup.size() < ansgrp.size()) {
          ansgrp = maxgroup;
          ansguess = guess;
        }
      }
    }

    return ansguess;
  }

}