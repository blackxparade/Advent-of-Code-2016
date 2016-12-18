import java.io.*;
import java.util.*;

public class day6 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    String input = "";
    List<String> inputLines = new ArrayList<String>();

    // Read the input.
    try(BufferedReader br = new BufferedReader(new FileReader("day6.txt"))) {
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
    String abc = "abcdefghijklmnopqrstuvwxyz";
    String message = "";

    for (int i=0; i<8; i++) {
      int[] abc_i = new int[abc.length()];
      for (int j=0; j<input.size(); j++) {
        int index = abc.indexOf(input.get(j).charAt(i));
        abc_i[index]++;
      }

      int max_index = 0;
      for (int j=0; j<abc.length(); j++)
        if (abc_i[j] > abc_i[max_index])
          max_index = j;

      message += abc.charAt(max_index);
    }
    System.out.println(message);

  }

  public static void Part_2(List<String> input) {
    String abc = "abcdefghijklmnopqrstuvwxyz";
    String message = "";

    for (int i=0; i<8; i++) {
      int[] abc_i = new int[abc.length()];
      for (int j=0; j<input.size(); j++) {
        int index = abc.indexOf(input.get(j).charAt(i));
        abc_i[index]++;
      }

      int min_index = 0;
      for (int j=0; j<abc.length(); j++)
        if (abc_i[j] < abc_i[min_index])
          min_index = j;

      message += abc.charAt(min_index);
    }
    System.out.println(message);

  }
}
