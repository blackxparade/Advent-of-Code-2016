import java.io.*;
import java.util.*;

public class day1 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    String input = "";

    // Read the input.
    try(BufferedReader br = new BufferedReader(new FileReader("day1.txt"))) {
      String line = br.readLine();

      while (line != null) {
        input += line;
        line = br.readLine();
      }
    }

    // Split the input string to a List of Strings.
    List<String> inputList = Arrays.asList(input.split(", "));


    Part_1(inputList);
    System.out.println("............................");
    Part_2(inputList);


  }




  public static void Part_1(List<String> inputList){
    int x = 0;
    int y = 0;

    Direction compass = Direction.NORTH;
    for (int i=0; i<inputList.size(); i++){

      if (compass == Direction.NORTH && inputList.get(i).charAt(0) == 'R'){
        compass = Direction.EAST;
        x += Integer.parseInt(inputList.get(i).substring(1));
        continue;
      }

      if (compass == Direction.NORTH && inputList.get(i).charAt(0) == 'L'){
        compass = Direction.WEST;
        x -= Integer.parseInt(inputList.get(i).substring(1));
        continue;
      }

      if (compass == Direction.SOUTH && inputList.get(i).charAt(0) == 'R'){
        compass = Direction.WEST;
        x -= Integer.parseInt(inputList.get(i).substring(1));
        continue;
      }

      if (compass == Direction.SOUTH && inputList.get(i).charAt(0) == 'L'){
        compass = Direction.EAST;
        x += Integer.parseInt(inputList.get(i).substring(1));
        continue;
      }

      if (compass == Direction.EAST && inputList.get(i).charAt(0) == 'R'){
        compass = Direction.SOUTH;
        y -= Integer.parseInt(inputList.get(i).substring(1));
        continue;
      }

      if (compass == Direction.EAST && inputList.get(i).charAt(0) == 'L'){
        compass = Direction.NORTH;
        y+= Integer.parseInt(inputList.get(i).substring(1));
        continue;
      }

      if (compass == Direction.WEST && inputList.get(i).charAt(0) == 'R'){
        compass = Direction.NORTH;
        y += Integer.parseInt(inputList.get(i).substring(1));
        continue;
      }

      if (compass == Direction.WEST && inputList.get(i).charAt(0) == 'L'){
        compass = Direction.SOUTH;
        y-= Integer.parseInt(inputList.get(i).substring(1));
        continue;
      }
    }
    System.out.println("Santa's route length: " + (Math.abs(x) + Math.abs(y)));
  }















  public static void Part_2(List<String> inputList){
    int x = 500;
    int y = 500;

    boolean[][] map = new boolean[1000][1000];

    Direction compass = Direction.NORTH;
    for (int i=0; i<inputList.size(); i++){
      int path = Integer.parseInt(inputList.get(i).substring(1));

      if (compass == Direction.NORTH && inputList.get(i).charAt(0) == 'R'){
        compass = Direction.EAST;
        for (int j=0; j<path; j++){
          if (!map[x][y+j])
            map[x][y+j] = true;
          else {
            System.out.println("First location visited twice: " + x + " " + (y+j));
            return;
          }
        }
        y += path;
        continue;
      }

      if (compass == Direction.NORTH && inputList.get(i).charAt(0) == 'L'){
        compass = Direction.WEST;
        for (int j=0; j<path; j++){
          if (!map[x][y-j])
            map[x][y-j] = true;
          else {
            System.out.println("First location visited twice: " + x + " " + (y-j));
            return;
          }
        }
        y -= path;
        continue;
      }

      if (compass == Direction.SOUTH && inputList.get(i).charAt(0) == 'R'){
        compass = Direction.WEST;
        for (int j=0; j<path; j++){
          if (!map[x][y-j])
            map[x][y-j] = true;
          else {
            System.out.println("First location visited twice: " + x + " " + (y-j));
            return;
          }
        }
        y -= path;
        continue;
      }

      if (compass == Direction.SOUTH && inputList.get(i).charAt(0) == 'L'){
        compass = Direction.EAST;
        for (int j=0; j<path; j++){
          if (!map[x][y+j])
            map[x][y+j] = true;
          else {
            System.out.println("First location visited twice: " + x + " " + (y+j));
            return;
          }
        }
        y += path;
        continue;
      }

      if (compass == Direction.EAST && inputList.get(i).charAt(0) == 'R'){
        compass = Direction.SOUTH;
        for (int j=0; j<path; j++){
          if (!map[x+j][y])
            map[x+j][y] = true;
          else {
            System.out.println("First location visited twice: " + (x+j) + " " + y);
            return;
          }
        }
        x += path;
        continue;
      }

      if (compass == Direction.EAST && inputList.get(i).charAt(0) == 'L'){
        compass = Direction.NORTH;
        for (int j=0; j<path; j++){
          if (!map[x-j][y])
            map[x-j][y] = true;
          else {
            System.out.println("First location visited twice: " + (x-j) + " " + y);
            return;
          }
        }
        x -= path;
        continue;
      }

      if (compass == Direction.WEST && inputList.get(i).charAt(0) == 'R'){
        compass = Direction.NORTH;
        for (int j=0; j<path; j++){
          if (!map[x-j][y])
            map[x-j][y] = true;
          else {
            System.out.println("First location visited twice: " + (x-j) + " " + y);
            return;
          }
        }
        x -= path;
        continue;
      }

      if (compass == Direction.WEST && inputList.get(i).charAt(0) == 'L'){
        compass = Direction.SOUTH;
        for (int j=0; j<path; j++){
          if (!map[x+j][y])
            map[x+j][y] = true;
          else {
            System.out.println("First location visited twice: " + (x+j) + " " + y);
            return;
          }
        }
        x += path;
        continue;
      }

    }
  }



}


enum Direction {
  NORTH, SOUTH, EAST, WEST
}
