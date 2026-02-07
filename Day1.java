import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Day1 {
  static int code = 50;
  static int cntZero = 0;

  public static void decrement(int move) {
    int d = code;
    if (d == 0) {
      cntZero += move / 100;
    } else if(move >= d) {
      cntZero += 1 + (move - d) / 100;
    }
    code = (code - move % 100 + 100) % 100;
    // int temp = code - move;
    // if (temp < 0 && code != 0) {
    //   System.out.println("new zero L: " +temp);
    //   cntZero++;
    // }
    // code = (code - move + 100) % 100;   
    // if (code == 0) 
    //   cntZero++;
    // System.out.println("L: " + move + ", " + code);
  }

  public static void increment(int move) {
    int distToZero = (100 - code) % 100;
    if (distToZero == 0 ) {
      cntZero += move / 100;
    } else if (move >= distToZero) {
      cntZero += 1 + (move - distToZero) / 100;
    }
    code = (code + move) % 100;
    // int temp = code + move;
    // if (temp > 100) {
    //   System.out.println("new zero R: " +temp);
    //   cntZero++;
    // }
    // code = (code + move) % 100;   
    // if (code == 0) 
    //   cntZero++;
    // System.out.println("R: " + move + ", " + code);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("inputDay1.txt"));    
    // BufferedReader br = new BufferedReader(new FileReader("inputDay1Demo.txt"));    
    String line = null;
    
    int len = 0;
    while((line = br.readLine())!= null) {
      len++;
      char c = line.charAt(0);
      int num = Integer.parseInt(line.substring(1));
      if (c == 'L') {
        decrement(num);
      } else {
        increment(num);
      }
    }
    System.out.println("input len: " + len);
    System.out.println("ans: " + cntZero);
    br.close();
  }
}
