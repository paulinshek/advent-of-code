package com.company.solutions.day3;

public enum Direction {
  RIGHT(0), UP(1), LEFT(2), DOWN(3);

  private int order;
  Direction(int order) {
    this.order = order;
  }

  public int getOrder() {
    return order;
  }

  public static Direction getFromOrder(int order) {
    Direction[] allDirections = Direction.values();
    for (Direction d: allDirections) {
      if (order == d.order) {
        return d;
      }
    }
    throw new UnsupportedOperationException("No Direction found with order " + order);
  }
}
