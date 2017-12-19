package com.company.solutions.day3;

import com.company.solutions.Solution;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpiralMemory extends Solution {
  @Override
  public void restorePuzzleInput() {
  }

  @Override
  public int getPartOneSolution() {
    List<MemorySquare> memoryPool = new ArrayList<>();

    memoryPool.add(new MemorySquare(0,0,1));
    int currentLayer = 1;
    Direction currentDirection = Direction.RIGHT;
    int progressAlongLayer = 1;
    int lastX = 0;
    int lastY = 0;

    for (int i=2; i<=347991; i++) {
      int newX;
      int newY;

      switch(currentDirection) {
        case UP:
          newX = lastX;
          newY = lastY + 1;
          break;
        case DOWN:
          newX = lastX;
          newY = lastY - 1;
          break;
        case LEFT:
          newX = lastX - 1;
          newY = lastY;
          break;
        case RIGHT:
          newX = lastX + 1;
          newY = lastY;
          break;
        default:
          throw new UnsupportedOperationException("ahh");
      }

      memoryPool.add(new MemorySquare(newX, newY, i));

      lastX = newX;
      lastY = newY;
      progressAlongLayer -= 1;

      if (progressAlongLayer == 0) {

        if (currentDirection == Direction.DOWN) {
          currentLayer += 1;
        }
        currentDirection = Direction.getFromOrder((currentDirection.getOrder() + 1) % 4);
        // length one side of the next layer - 1
        progressAlongLayer = 2*currentLayer - 1;
        if (Arrays.asList(Direction.LEFT, Direction.DOWN).contains(currentDirection)) {
          progressAlongLayer += 1;
        }
      }
    }
    return Math.abs(lastX) + Math.abs(lastY);
  }

  @Override
  public int getPartTwoSolution() {
//    BoardState boardState = new BoardState();
//
//    for (int i=2; i<=347991; i++) {
//      Location nextLocation = NavigationService.findAdjacentLocation(boardState.getCurrentLocation(), boardState.getCurrentDirection());
//
//      calculateSumOfAdjacentSquares();
//      memoryPool.put(new Location(newX, newY), i);
//
//      lastX = newX;
//      lastY = newY;
//      progressAlongLayer -= 1;
//
//      if (progressAlongLayer == 0) {
//
//        if (currentDirection == Direction.DOWN) {
//          currentLayer += 1;
//        }
//        currentDirection = Direction.getFromOrder((currentDirection.getOrder() + 1) % 4);
//        // length one side of the next layer - 1
//        progressAlongLayer = 2*currentLayer - 1;
//        if (Arrays.asList(Direction.LEFT, Direction.DOWN).contains(currentDirection)) {
//          progressAlongLayer += 1;
//        }
//      }
//    }
//    return Math.abs(lastX) + Math.abs(lastY);
    return 0;
  }

  private int calculateSumOfAdjacentSquares(int x, int y, int progressAlongLayer, Direction direction) {
//    if (progressAlongLayer == 0) {
//      // then corner piece
//      switch(direction) {
//        case DOWN:
//          // bottom left
//          return map.get(x, y+1) + map.get(x + 1, y+1);
//          break;
//        case LEFT:
//          // bottom right
//          return map.get(x-1, y) + map.get(x-1, y+1);
//          break;
//        case RIGHT:
//          //top left
//          return map.get(x+1, y) + map.get(x+1, y-1);
//          break;
//        case UP:
//          // top right
//          return map.get(x, y-1) + map.get(x-1, y-1);
//        default:
//          throw new UnsupportedOperationException("sdfjs");
//      }
//    }
    return 0;
  }
}
