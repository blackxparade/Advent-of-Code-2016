import java.io.*;
import java.util.*;


public class day3 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    String input = "";
    List<String> inputLines = new ArrayList<String>();

    // Read the input.
    try(BufferedReader br = new BufferedReader(new FileReader("day3.txt"))) {
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
    int possible = 0;

    for (int i=0; i<input.size(); i++) {
      List<String> sides = Arrays.asList(input.get(i).trim().split(" +"));

        int x = Integer.parseInt(sides.get(0));
        int y = Integer.parseInt(sides.get(1));
        int z = Integer.parseInt(sides.get(2));

        if (x + y > z && x + z > y && y + z > x)
          possible++;
    }

    System.out.println("Possible triangles: " + possible);
  }



  public static void Part_2(List<String> input) {
    int possible = 0;

    for (int i=0; i<input.size(); i+=3) {
      List<String> sides1 = Arrays.asList(input.get(i).trim().split(" +"));
      List<String> sides2 = Arrays.asList(input.get(i+1).trim().split(" +"));
      List<String> sides3 = Arrays.asList(input.get(i+2).trim().split(" +"));

      int x = Integer.parseInt(sides1.get(0));
      int y = Integer.parseInt(sides2.get(0));
      int z = Integer.parseInt(sides3.get(0));

      if (x + y > z && x + z > y && y + z > x)
        possible++;

      x = Integer.parseInt(sides1.get(1));
      y = Integer.parseInt(sides2.get(1));
      z = Integer.parseInt(sides3.get(1));

      if (x + y > z && x + z > y && y + z > x)
        possible++;

      x = Integer.parseInt(sides1.get(2));
      y = Integer.parseInt(sides2.get(2));
      z = Integer.parseInt(sides3.get(2));

      if (x + y > z && x + z > y && y + z > x)
        possible++;
    }
    System.out.println("Possible triangles: " + possible);
  }
}
