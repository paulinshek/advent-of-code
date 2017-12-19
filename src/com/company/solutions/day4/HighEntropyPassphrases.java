package com.company.solutions.day4;

import com.company.solutions.Solution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class HighEntropyPassphrases extends Solution {
  @Override
  public void restorePuzzleInput() {

  }

  @Override
  public int getPartOneSolution() {
    // This will reference one line at a time
    String line = null;
    // count of valid lines
    int validLines = 0;

    try {
      // FileReader reads text files in the default encoding.
      FileReader fileReader =
        new FileReader("resources/day4.txt");

      // Always wrap FileReader in BufferedReader.
      BufferedReader bufferedReader =
        new BufferedReader(fileReader);

      while ((line = bufferedReader.readLine()) != null) {
        String[] words = line.trim().split(" ");
        List<String> wordList = Arrays.asList(words);
        int originalWordCount = words.length;
        int uniqueWordCount = (new HashSet<>(wordList)).size();
        validLines += (originalWordCount == uniqueWordCount ? 1 : 0);
      }

      // Always close files.
      bufferedReader.close();
    } catch (FileNotFoundException ex) {
      System.out.println(
        "Unable to open file");
    } catch (IOException ex) {
      System.out.println(
        "Error reading file");
      // Or we could just do this:
      // ex.printStackTrace();
    }


    return validLines;
  }

  @Override
  public int getPartTwoSolution() {
     //This will reference one line at a time
      String line = null;
      // count of valid lines
      int validLines = 0;

        try {
      // FileReader reads text files in the default encoding.
      FileReader fileReader =
        new FileReader("resources/day4.txt");

      // Always wrap FileReader in BufferedReader.
      BufferedReader bufferedReader =
        new BufferedReader(fileReader);

      while((line = bufferedReader.readLine()) != null) {
        String[] words = line.trim().split(" ");
        List<String> anagramList = Arrays.stream(words).map(word -> {
          char[] charArray = word.toCharArray();
          Arrays.sort(charArray);
          return new String(charArray);
        }).collect(Collectors.toList());
        int originalWordCount = words.length;
        int uniqueAnagramCount = (new HashSet<>(anagramList)).size();
        validLines += (originalWordCount==uniqueAnagramCount ? 1 : 0 );
      }

      // Always close files.
      bufferedReader.close();
    }
        catch(FileNotFoundException ex) {
      System.out.println(
        "Unable to open file");
    }
        catch(IOException ex) {
      System.out.println(
        "Error reading file");
      // Or we could just do this:
      // ex.printStackTrace();
    }

    return validLines;
  }
}
