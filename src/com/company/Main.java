package com.company;

import com.company.solutions.Solution;
import com.company.solutions.day1.InverseCaptcha;
import com.company.solutions.day2.CorruptionChecksum;
import com.company.solutions.day3.SpiralMemory;
import com.company.solutions.day4.HighEntropyPassphrases;
import com.company.solutions.day5.TrampolineMaze;
import com.company.solutions.day6.MemoryReallocation;

public class Main {

    public static void main(String[] args) {
      Solution solution = new MemoryReallocation();

      System.out.println("Part 1 solution is: " + solution.getPartOneSolution());

      System.out.println("Part 2 solution is: " + solution.getPartTwoSolution());
    }
}
