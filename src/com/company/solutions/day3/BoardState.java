package com.company.solutions.day3;

import java.util.HashMap;
import java.util.Map;

public class BoardState {
  private Map<Location, Integer> memoryPool;
  private int currentLayer;
  private Direction currentDirection;
  private int progressAlongLayer;
  private Location currentLocation;

  public BoardState() {
    this.currentLocation = new Location(0,0);
    this.memoryPool = new HashMap<>();
    this.memoryPool.put(currentLocation, 1);
    this.currentLayer = 1;
    this.currentDirection = Direction.RIGHT;
    this.progressAlongLayer = 1;
  }

  public int getCurrentLayer() {
    return currentLayer;
  }

  public Direction getCurrentDirection() {
    return currentDirection;
  }

  public int getProgressAlongLayer() {
    return progressAlongLayer;
  }

  public Location getCurrentLocation() {
    return currentLocation;
  }

  public Integer getValueAt(Location location) {
    return memoryPool.get(location);
  }

  public void addValueAt(Location location, Integer value) {
    memoryPool.put(location,value);
  }
}
