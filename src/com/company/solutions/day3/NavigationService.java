package com.company.solutions.day3;

public class NavigationService {

  public static Location findAdjacentLocation(Location location, Direction direction) {
    int newX;
    int newY;
    switch(direction) {
      case UP:
        newX = location.getX();
        newY = location.getY() + 1;
        break;
      case DOWN:
        newX = location.getX();
        newY = location.getY() - 1;
        break;
      case LEFT:
        newX = location.getX() - 1;
        newY = location.getY();
        break;
      case RIGHT:
        newX = location.getX() + 1;
        newY = location.getY();
        break;
      default:
        throw new UnsupportedOperationException("ahh");
    }

    return new Location(newX, newY);
  }
}
