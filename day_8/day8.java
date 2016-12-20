import java.io.*;
import java.util.*;

public class day8 {
  static boolean[][] display = new boolean[50][6];

  public static void main(String[] args) throws FileNotFoundException, IOException {
    String input = "";
    List<String> inputLines = new ArrayList<String>();

    // Read the input.
    try(BufferedReader br = new BufferedReader(new FileReader("day8.txt"))) {
      String line = br.readLine();


      while (line != null) {
        inputLines.add(line);
        input += line;
        line = br.readLine();
      }
    }

    //System.out.println(input);
    //System.out.println(inputLines.get(4));
    Part_1(inputLines);
    //Part_2(inputLines);
  }

  public static void Part_1(List<String> input) {
    int count = 0;
    for (int i=0; i<input.size(); i++) {
      List<String> instructions = Arrays.asList(input.get(i).split(" "));
      System.out.println(instructions);

      if (instructions.get(0).contains("rect"))
        lightUp(instructions.get(1));
      if (instructions.get(0).contains("rotate"))
        rotate(instructions);

      printDisplay();
    }

    for (int i=0; i<6; i++)
      for (int j=0; j<50; j++)
        if (display[j][i])
          count++;

    System.out.println(count);

  }

  public static void lightUp(String rect) {
    List<String> sides = Arrays.asList(rect.split("x"));
    int x = Integer.parseInt(sides.get(0));
    int y = Integer.parseInt(sides.get(1));
    //System.out.println(x + " " + y);

    for (int i=0; i<x; i++)
      for (int j=0; j<y; j++)
        display[i][j] = true;
  }

  public static void rotate(List<String> instruction) {
    boolean rowToRotate = false;
    int rotateBy = Integer.parseInt(instruction.get(instruction.size()-1));
    List<String> whichColumnRow = Arrays.asList(instruction.get(2).split("="));
    int whichColumnRow_i = Integer.parseInt(whichColumnRow.get(1));

    if (instruction.get(1).contains("row"))
      rowToRotate = true;

    if (!rowToRotate) {
      boolean[] temp = new boolean[6];
      for (int i=0; i<6; i++)
        temp[(i + rotateBy) % 6] = display[whichColumnRow_i][i];

      for (int i=0; i<6; i++)
        display[whichColumnRow_i][i] = temp[i];
    }

    if (rowToRotate) {
      boolean[] temp = new boolean[50];
      for (int i=0; i<50; i++)
        temp[(i + rotateBy) % 50] = display[i][whichColumnRow_i];

      for (int i=0; i<50; i++)
        display[i][whichColumnRow_i] = temp[i];
    }

    //System.out.println("Rotate by: " + rotateBy + " which column or row: " + whichColumnRow_i);




  }

  public static void printDisplay() {
    for (int i=0; i<6; i++) {
      for (int j=0; j<50; j++) {
        if (display[j][i])
          System.out.print("1 ");
        else System.out.print(". ");
      }
      System.out.println();
    }
  }

}
