import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Day3 {

  static String findBigNum(String line) {
    int len = line.length();
    int bigFirst = -10;
    int firstPos = -1;
    for (int i=0; i<len-1; i++) {
      int a = Integer.parseInt(line.charAt(i) + ""); 
      if (a > bigFirst) {
        bigFirst = a;
        firstPos = i;
      }
    }
    int bigSecond = -10;
    for (int i=firstPos+1; i<len; i++) {
      int b = Integer.parseInt(line.charAt(i) + ""); 
      if (b > bigSecond) 
        bigSecond = b;
    }
    return bigFirst + "" + bigSecond;
  }

  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new FileReader("inputs/inputDay3Demo.txt"));
    BufferedReader br = new BufferedReader(new FileReader("inputs/inputDay3.txt"));
    String line = null;
    int total = 0;
    while ((line = br.readLine()) != null) {
      String res = findBigNum(line); 
      System.out.println(res);
      total += Integer.parseInt(res);
    }

    System.out.println("Part1: " + total);
    br.close();
  }
}
