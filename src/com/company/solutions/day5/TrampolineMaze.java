package com.company.solutions.day5;

import com.company.solutions.Solution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class TrampolineMaze extends Solution {
  public static String INPUT_FILE = "resources/day5.txt";
  private Integer[] jumpOffsets;

  public TrampolineMaze() {
    restorePuzzleInput();
  }

  @Override
  public void restorePuzzleInput() {
    try {
      FileReader fileReader = new FileReader(INPUT_FILE);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      jumpOffsets = bufferedReader.lines().map(Integer::valueOf).toArray(Integer[]::new);

      bufferedReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void setTestInput(String input) {
    jumpOffsets = Arrays.stream(input.split("\\n")).map(Integer::valueOf).toArray(Integer[]::new);
  }

  @Override
  public int getPartOneSolution() {
    int moveCount = 0;

    Integer endOfMaze = jumpOffsets.length;
    Integer currentPosition = 0;

    while (currentPosition < endOfMaze) {
      int oldPosition = currentPosition;
      currentPosition += jumpOffsets[oldPosition];
      jumpOffsets[oldPosition] += 1;
      moveCount += 1;
    }

    return moveCount;
  }

  @Override
  public int getPartTwoSolution() {
    int moveCount = 0;
    Integer endOfMaze = jumpOffsets.length;
    Integer currentPosition = 0;

    while (currentPosition < endOfMaze) {
      int oldPosition = currentPosition;
      currentPosition += jumpOffsets[oldPosition];
      if (jumpOffsets[oldPosition] >= 3) {
        jumpOffsets[oldPosition] -= 1;
      } else {
        jumpOffsets[oldPosition] += 1;
      }
      moveCount += 1;
    }

    return moveCount;
  }
}
