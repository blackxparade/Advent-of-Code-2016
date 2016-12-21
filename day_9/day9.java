import java.io.*;
import java.util.*;

public class day9 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    String input = "";
    List<String> inputLines = new ArrayList<String>();

    // Read the input.
    try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
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
    String decompressed = "";
    for (int i=0; i<input.size(); i++) {
      System.out.println(input.get(i));
      boolean bracket = false;
      String marker = "";
      boolean wasOpen  = false;

      for (int j=0; j<input.get(i).length(); j++) {
        if(!bracket && !wasOpen && input.get(i).charAt(j) != '(')
          decompressed += input.get(i).charAt(j);

        if (input.get(i).charAt(j) == '(') {
          bracket = true;
          wasOpen = true;
        }
        if (input.get(i).charAt(j) == ')' && wasOpen) {
          bracket = false;
          wasOpen = false;
          marker = marker.replaceAll("\\(","");
          List<String> params = Arrays.asList(marker.split("x"));
          System.out.println(params);

          int length = Integer.parseInt(params.get(0));
          int times = Integer.parseInt(params.get(1));

          for (int k=0; k<times; k++)
            decompressed += input.get(i).substring(j+1, j+length+1);

          j += length;

        }



        if (bracket) marker += input.get(i).charAt(j);
        if (!bracket) marker = "";
      }
    }

    System.out.println(decompressed.length());
  }




  public static void Part_2(List<String> input) {
    int stringlength = 0;
    for (int i=0; i<input.size(); i++) {
      boolean bracket = false;
      String marker = "";
      for (int j=input.get(i).length()-1; j>=0; j--) {
        if (input.get(i).charAt(j) != ')' && input.get(i).charAt(j) != '(' && !bracket)
          stringlength++;

        if (input.get(i).charAt(j) == ')')
          bracket = true;

        if (input.get(i).charAt(j) == '(') {
          bracket = false;



          int k = 0;
          while (input.get(i).charAt(j+k) != ')') {
            marker += input.get(i).charAt(j+k);
            k++;
          }

          marker = marker.replaceAll("\\(","");
          marker = marker.replaceAll("\\)","");
          List<String> params = Arrays.asList(marker.split("x"));
          marker = "";
          System.out.println(params);

          int length = Integer.parseInt(params.get(0));
          int times = Integer.parseInt(params.get(1));

          stringlength -= length;
          stringlength += length * times;
        }
      }
    }

    System.out.println(stringlength);

  }


}
