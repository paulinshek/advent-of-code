package com.company.solutions.day6;

import com.company.solutions.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MemoryReallocation extends Solution {

  public MemoryReallocation() {
    restorePuzzleInput();
  }

  @Override
  public void setTestInput(String input) {
    super.setTestInput(input);
  }

  @Override
  public void restorePuzzleInput() {
    this.input = "4	1	15	12	0	9	9	5	5	8	7	3	14	5	12	3";
  }

  @Override
  public int getPartOneSolution() {
    Integer[] currentPosition = Stream.of(input.split("\\W+")).map(Integer::valueOf).toArray(Integer[]::new);
    int n = currentPosition.length;
    int k;
    ArrayList<Integer[]> positionHistory = new ArrayList<>();
    boolean repeatFound = false;


    while (!repeatFound) {
      // calculate move
      k = findPositionOfMax(currentPosition, n);
      Integer[] nextMove = Collections.nCopies(n, currentPosition[k] / n).toArray(new Integer[0]);
      nextMove[k] -= currentPosition[k];
      int marker = (k + currentPosition[k]) % n;
      if (k < marker) {
        for (int i=k+1; i<=marker; i++) {
          nextMove[i] += 1;
        }
      } else if (marker < k) {
        for (int i=0; i<=marker; i++) {
          nextMove[i] += 1;
        }
        for (int i=k+1; i<n; i++) {
          nextMove[i] += 1;
        }
      }
       // else k==marker and the blocks can be shared evenly so we have none leftover

      Integer[] nextPosition = nextPosition(currentPosition, nextMove, n);
      repeatFound = positionHistory.stream().anyMatch(pastPosition -> {
        boolean sameSoFar = true;
        for(int i=0; i<n; i++) {
          sameSoFar = sameSoFar && pastPosition[i].equals(nextPosition[i]);
        }
        return sameSoFar;
      });
      positionHistory.add(nextPosition);
      currentPosition = nextPosition;
    }

    return positionHistory.size();
  }

  private int findPositionOfMax(Integer[] position, int length) {
    int positionOfMax = 0;
    for (int i=1; i<length; i++) {
      if (position[i] > position[positionOfMax]) {
        positionOfMax = i;
      }
    }
    return positionOfMax;
  }

  private Integer[] nextPosition(Integer[] position, Integer[] move, int length) {
    Integer[] result = new Integer[length];
    for (int i = 0; i < length; i++ ) {
      result[i] = position[i] + move[i];
    }
    return result;
  }

  @Override
  public int getPartTwoSolution() {
    Integer[] currentPosition = Stream.of(input.split("\\W+")).map(Integer::valueOf).toArray(Integer[]::new);
    int n = currentPosition.length;
    int k;
    ArrayList<Integer[]> positionHistory = new ArrayList<>();
    OptionalInt repeatFound = OptionalInt.empty();


    while (!repeatFound.isPresent()) {
      // calculate move
      k = findPositionOfMax(currentPosition, n);
      Integer[] nextMove = Collections.nCopies(n, currentPosition[k] / n).toArray(new Integer[0]);
      nextMove[k] -= currentPosition[k];
      int marker = (k + currentPosition[k]) % n;
      if (k < marker) {
        for (int i=k+1; i<=marker; i++) {
          nextMove[i] += 1;
        }
      } else if (marker < k) {
        for (int i=0; i<=marker; i++) {
          nextMove[i] += 1;
        }
        for (int i=k+1; i<n; i++) {
          nextMove[i] += 1;
        }
      }
      // else k==marker and the blocks can be shared evenly so we have none leftover

      Integer[] nextPosition = nextPosition(currentPosition, nextMove, n);


      repeatFound = IntStream.range(0, positionHistory.size())
        .filter(i -> {
          boolean sameSoFar = true;
          for(int j=0; j<n; j++) {
            sameSoFar = sameSoFar && positionHistory.get(i)[j].equals(nextPosition[j]);
          }
          return sameSoFar;
        }).findFirst();




      positionHistory.add(nextPosition);
      currentPosition = nextPosition;
    }

    return positionHistory.size() - repeatFound.getAsInt() - 1;
  }
}
