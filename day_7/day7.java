import java.io.*;
import java.util.*;

public class day7 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    String input = "";
    List<String> inputLines = new ArrayList<String>();

    // Read the input.
    try(BufferedReader br = new BufferedReader(new FileReader("day7.txt"))) {
      String line = br.readLine();


      while (line != null) {
        inputLines.add(line);
        input += line;
        line = br.readLine();
      }
    }

    //System.out.println(input);
    //System.out.println(inputLines.get(4));
    //Part_1(inputLines);
    Part_2(inputLines);
  }





  public static void Part_1(List<String> input) {
    int count=0;
    for (int i=0; i<input.size(); i++) {

      List<String> nonbracket = new ArrayList<String>();
      List<String> bracket = new ArrayList<String>();
      String temp = "";
      boolean inside = false;

      for (int j=0; j<input.get(i).length(); j++) {

        if (input.get(i).charAt(j) == '['){
          inside = true;
          nonbracket.add(temp);
          temp = "";
        }

        if (input.get(i).charAt(j) == ']'){
          inside = false;
          temp += input.get(i).charAt(j);
          bracket.add(temp);
          temp = "";
        }

        if (inside || !inside)
          temp += input.get(i).charAt(j);
      }

      nonbracket.add(temp);

      for (int j=0; j<nonbracket.size(); j++) {
        nonbracket.set(j, nonbracket.get(j).replaceAll("\\[",""));
        nonbracket.set(j, nonbracket.get(j).replaceAll("\\]",""));
      }

      for (int j=0; j<bracket.size(); j++) {
        bracket.set(j, bracket.get(j).replaceAll("\\[",""));
        bracket.set(j, bracket.get(j).replaceAll("\\]",""));
      }

      System.out.println(input.get(i));
      System.out.println("nonbracket: " + nonbracket);
      System.out.println("bracket: " + bracket);
      System.out.println();

      if (validIP(bracket, nonbracket))
        count++;
    }
    System.out.println(count);
  }


  public static boolean validIP(List<String> bracket, List<String> nonbracket) {

    for (int i=0; i<bracket.size(); i++) {
      for (int j=0; j<bracket.get(i).length()-3; j++) {
        if (bracket.get(i).charAt(j) == bracket.get(i).charAt(j+3) &&
            bracket.get(i).charAt(j+1) == bracket.get(i).charAt(j+2) &&
            bracket.get(i).charAt(j) != bracket.get(i).charAt(j+1))
              return false;
      }
    }

    for (int i=0; i<nonbracket.size(); i++) {
      for (int j=0; j<nonbracket.get(i).length()-3; j++) {
        if (nonbracket.get(i).charAt(j) == nonbracket.get(i).charAt(j+3) &&
            nonbracket.get(i).charAt(j+1) == nonbracket.get(i).charAt(j+2) &&
            nonbracket.get(i).charAt(j) != nonbracket.get(i).charAt(j+1))
              return true;
      }
    }


    return false;

  }






  public static void Part_2(List<String> input) {
    int count=0;
    for (int i=0; i<input.size(); i++) {

      List<String> nonbracket = new ArrayList<String>();
      List<String> bracket = new ArrayList<String>();
      String temp = "";
      boolean inside = false;

      for (int j=0; j<input.get(i).length(); j++) {

        if (input.get(i).charAt(j) == '['){
          inside = true;
          nonbracket.add(temp);
          temp = "";
        }

        if (input.get(i).charAt(j) == ']'){
          inside = false;
          temp += input.get(i).charAt(j);
          bracket.add(temp);
          temp = "";
        }

        if (inside || !inside)
          temp += input.get(i).charAt(j);
      }

      nonbracket.add(temp);

      for (int j=0; j<nonbracket.size(); j++) {
        nonbracket.set(j, nonbracket.get(j).replaceAll("\\[",""));
        nonbracket.set(j, nonbracket.get(j).replaceAll("\\]",""));
      }

      for (int j=0; j<bracket.size(); j++) {
        bracket.set(j, bracket.get(j).replaceAll("\\[",""));
        bracket.set(j, bracket.get(j).replaceAll("\\]",""));
      }

      System.out.println(input.get(i));
      System.out.println("nonbracket: " + nonbracket);
      System.out.println("bracket: " + bracket);
      System.out.println();

      if (validSSL(bracket, nonbracket))
        count++;
    }
    System.out.println(count);
  }


  public static boolean validSSL(List<String> bracket, List<String> nonbracket) {
    String s = "";
    for (int i=0; i<bracket.size(); i++) {
      for (int j=0; j<bracket.get(i).length()-2; j++) {
        if (bracket.get(i).charAt(j) == bracket.get(i).charAt(j+2) &&
            bracket.get(i).charAt(j) != bracket.get(i).charAt(j+1)) {
              s += bracket.get(i).charAt(j+1);
              s += bracket.get(i).charAt(j);
              s += bracket.get(i).charAt(j+1);
              if (inNonbracket(s, nonbracket))
                return true;
            }
            s = "";

      }
    }
    return false;
  }

  public static boolean inNonbracket(String s, List<String> nonbracket) {

    for (int i=0; i<nonbracket.size(); i++)
      if (nonbracket.get(i).indexOf(s) > -1)
        return true;

    return false;
  }

}
