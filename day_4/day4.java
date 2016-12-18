import java.io.*;
import java.util.*;

public class day4 {

  public static void main(String[] args) throws FileNotFoundException, IOException {
    String input = "";
    List<String> inputLines = new ArrayList<String>();

    // Read the input.
    try(BufferedReader br = new BufferedReader(new FileReader("day4.txt"))) {
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

  public static class Letter {
    char c;
    int x = 0;

    Letter (char c, int x) {
      this.c = c;
      this.x = x;
    }

    public String toString() {
      return this.c + " " + this.x + " ";
    }

  }


  public static void Part_1(List<String> input) {
    int sum = 0;
    for (int i=0; i<input.size(); i++) {
      //System.out.println(input.get(i));
      List<String> codes = Arrays.asList(input.get(i).split("-"));
      String cat = "";

      for (int j=0; j<codes.size()-1; j++)
        cat += codes.get(j);



      System.out.println(cat);
      List<Letter> l = new ArrayList<Letter>();


      for (int j=0; j<cat.length(); j++) {
        char actualLetter = cat.charAt(j);
        Letter l_ = new Letter(actualLetter,findAndCount(cat, actualLetter));

        if (!Lcontains(l, l_))
          l.add(l_);

        //System.out.println("L size: " + l.size() + " cat size: " + cat.length());
      }

      order(l);
      lex(l);
      //System.out.println(l);

      String hash = "";
      for (int j=0; j<5; j++)
        hash += l.get(j).c;


/*
      List<Letter> top5 = new ArrayList<Letter>();

      for(int j=0; j<5; j++) {
        int max_index = 0;

        for(int k=0; k<l.size(); k++)
          if (l.get(k).x >= l.get(max_index).x)
            max_index = k;

          top5.add(l.get(max_index));
          l.remove(max_index);
      }
      lex(top5);
      String hash = "";
      for (int j=0; j<5; j++)
        hash += top5.get(j).c;

        */

      System.out.println(hash + " " + codes.get(codes.size()-1));
      if (hash.equals(codes.get(codes.size()-1).substring(4,9)))
        sum += Integer.parseInt(codes.get(codes.size()-1).substring(0,3));
      System.out.println(sum + " " + Integer.parseInt(codes.get(codes.size()-1).substring(0,3)));

    }


}

    public static void lex(List<Letter> l) {
      for(int j=0; j<l.size()-1; j++) {
        for (int i=0; i<l.size()-1; i++) {
          if (l.get(i).x == l.get(i+1).x && l.get(i).c > l.get(i+1).c) {
            Letter temp = l.get(i);
            l.set(i,l.get(i+1));
            l.set(i+1,temp);
          }
        }
      }
    }

    public static void order(List<Letter> l) {
      for(int j=0; j<l.size()-1; j++) {
        for (int i=0; i<l.size()-1; i++) {
          if (l.get(i).x < l.get(i+1).x) {
            Letter temp = l.get(i);
            l.set(i,l.get(i+1));
            l.set(i+1,temp);
          }
        }
      }
    }


    public static int findAndCount(String word, char letter) {
      int count = 0;

      for (int i=0; i<word.length(); i++)
        if (word.charAt(i) == letter)
          count++;

      return count;
    }

    public static boolean Lcontains (List<Letter> l, Letter l_) {
      for (int i=0; i<l.size(); i++)
        if (l.get(i).c == l_.c && l.get(i).x == l_.x)
          return true;

      return false;
    }










    public static void Part_2(List<String> input) {
      String abc = "abcdefghijklmnopqrstuvwxyz";
      int len = abc.length();

      for (int i=0; i<input.size(); i++) {
        List<String> codes = Arrays.asList(input.get(i).split("-"));
        String room = "";
        int times = Integer.parseInt(codes.get(codes.size()-1).substring(0,3))%len;

        for(int j=0; j<codes.size()-1; j++)
          room += codes.get(j) + " ";

        //System.out.println("a" + " " + times + " = " + abc.charAt(abc.indexOf('z')+times));

        String decrypted_room = "";
        for(int j=0; j<room.length(); j++) {
          //decrypted_room += room.charAt(j) + times;
          if(room.charAt(j) == ' ') continue;

          if (abc.indexOf(room.charAt(j)) + times >= abc.length()) {
            decrypted_room += abc.charAt( (abc.indexOf(room.charAt(j)) + times) - abc.length());
          }
          else decrypted_room += abc.charAt(abc.indexOf(room.charAt(j) + times));
        }

        if (decrypted_room.contains("north"))
          System.out.println(codes.get(codes.size()-1).substring(0,3));

      }


    }

  }
