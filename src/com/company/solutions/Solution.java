package com.company.solutions;

public abstract class Solution {
  protected String input;
  public void setTestInput(String input) {
    this.input = input;
  }
  public abstract void restorePuzzleInput();
  public abstract int getPartOneSolution();
  public abstract int getPartTwoSolution();
}
