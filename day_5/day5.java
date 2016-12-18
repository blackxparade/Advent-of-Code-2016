import java.io.*;
import java.util.*;
import java.security.*;
import java.math.*;


public class day5 {

  public static void main(String[] args) throws NoSuchAlgorithmException{
    String input = "ojvtpuvg";


    //System.out.println(input);
    //System.out.println(inputLines.get(4));
    //Part_1(input);
    Part_2(input);
  }

  public static void Part_1(String input) throws NoSuchAlgorithmException {
    MessageDigest m=MessageDigest.getInstance("MD5");
    int done = 0;
    int i=0;

    while (done < 8) {
      String s = input + i;

      m.update(s.getBytes(),0,s.length());
      BigInteger bi = new BigInteger(1,m.digest());
      String md5 = String.format("%0" + (16 << 1) + "X", bi);


      if (md5.substring(0,5).equals("00000")){
        System.out.println(md5);
        done++;
      }

      i++;
    }

  }




  public static void Part_2(String input) throws NoSuchAlgorithmException {
    MessageDigest m=MessageDigest.getInstance("MD5");
    char[] password = { '.', '.', '.', '.', '.', '.', '.', '.' };
    int done = 0;
    int i=0;

    while (done < 8) {
      String s = input + i;

      m.update(s.getBytes(),0,s.length());
      BigInteger bi = new BigInteger(1,m.digest());
      String md5 = String.format("%0" + (16 << 1) + "X", bi);
      String pos = String.valueOf(md5.charAt(5));

      if (md5.substring(0,5).equals("00000")){
        if (Integer.parseInt(pos,16) < 8 && password[Integer.parseInt(pos,16)] == '.') {
          System.out.println(md5);
          password[Integer.parseInt(pos,16)] = md5.charAt(6);
          done++;
        }
      }

      i++;
    }
    System.out.println(password);

  }
}
