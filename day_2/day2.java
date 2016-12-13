import java.io.*;
import java.util.*;

public class day2 {


  public static void main(String[] args) throws FileNotFoundException, IOException {
    String input = "";
    List<String> inputLines = new ArrayList<String>();

    // Read the input.
    try(BufferedReader br = new BufferedReader(new FileReader("day2.txt"))) {
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
    System.out.println(".................................");
    Part_2(inputLines);
  }


  public static void Part_1(List<String> input) {
    int[][] keypad = new int[3][3];
    int x = 1;
    int y = 1;

    for (int i=0; i<3; i++)
      for (int j=0; j<3; j++)
        keypad[i][j] = (i*3 + j) + 1;

    System.out.println("The code is: ");

    for (int i=0; i<input.size(); i++) {
      for (int j=0; j<input.get(i).length(); j++) {

        if (input.get(i).charAt(j) == 'D') {
          if (y == 2)
            y = 2;
          else
            y += 1;
        }

        if (input.get(i).charAt(j) == 'U') {
            if (y == 0)
              y = 0;
            else
              y -= 1;
          }

        if (input.get(i).charAt(j) == 'R') {
            if (x == 2)
              x = 2;
            else
              x += 1;
          }

        if (input.get(i).charAt(j) == 'L') {
            if (x == 0)
              x = 0;
            else
              x -= 1;
          }

          //System.out.println(input.get(i).charAt(j) + " " + keypad[y][x]);
      }
      System.out.print(keypad[y][x]);
    }
    System.out.println();
  }


  public static void Part_2(List<String> input) {
    int[][] keypad = new int[5][5];
    keypad[0][2] = 1;
    keypad[1][1] = 2;
    keypad[1][2] = 3;
    keypad[1][3] = 4;
    keypad[2][0] = 5;
    keypad[2][1] = 6;
    keypad[2][2] = 7;
    keypad[2][3] = 8;
    keypad[2][4] = 9;
    keypad[3][1] = 10;
    keypad[3][2] = 11;
    keypad[3][3] = 12;
    keypad[4][2] = 13;

    int x = 0;
    int y = 2;

    for (int i=0; i<5; i++) {
      for (int j=0; j<5; j++)
        System.out.print(keypad[i][j] + " ");
      System.out.println();
    }

    System.out.println("The code is: ");

    for (int i=0; i<input.size(); i++) {
      for (int j=0; j<input.get(i).length(); j++) {

        if (input.get(i).charAt(j) == 'D') {
          if (y == 4 || keypad[y+1][x] == 0)
            y = y;
          else
            y += 1;
        }

        if (input.get(i).charAt(j) == 'U') {
            if (y == 0 || keypad[y-1][x] == 0)
              y = y;
            else
              y -= 1;
          }

        if (input.get(i).charAt(j) == 'R') {
            if (x == 4 || keypad[x+1][y] == 0)
              x = x;
            else
              x += 1;
          }

        if (input.get(i).charAt(j) == 'L') {
            if (x == 0 || keypad[x-1][y] == 0)
              x = x;
            else
              x -= 1;
          }

          //System.out.println(input.get(i).charAt(j) + " " + keypad[y][x]);
      }
      System.out.print(keypad[y][x] + " ");
    }
    System.out.println();


  }




}
