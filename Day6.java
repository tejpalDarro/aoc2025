import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Day6 {
  static void part1(List<int[]> numbers, char[] ops) {
    long total = 0;
    for (int col=0; col<ops.length; col++) {
      
      char op = ops[col];
      long res;

      if (op == '*') {
        res = 1;
        for (int rowIdx = 0; rowIdx < numbers.size(); rowIdx++) {
          res *= numbers.get(rowIdx)[col];
        }
      } else {
        res = 0;
        for (int rowIdx = 0; rowIdx < numbers.size(); rowIdx++) {
          res += numbers.get(rowIdx)[col];
        }
      }
    System.out.println("col: " + col + " result = " + res);
    total += res;
    }
    System.out.println("Part1 ans: " + total);
  }

  public static void main(String[] args) throws IOException {

    List<int[]> numbers = new ArrayList<>();
    char[] ops = null;

    // BufferedReader br = new BufferedReader(new FileReader("inputs/inputDay6Demo.txt"));
    BufferedReader br = new BufferedReader(new FileReader("inputs/inputDay6.txt"));
    String line = null;
    int row = 0;

    while (( line = br.readLine() ) != null) {

      line = line.trim();
      if(line.isEmpty()) continue;

      String[] str = line.split("\\s+");

      if (row == 4) { // for demo input use row == 3
        ops = new char[str.length];
        for (int i=0; i<str.length; i++) {
          ops[i] = str[i].charAt(0);
        }
      } else {
        int[] arr = new int[str.length];
        for (int i=0; i<str.length; i++) {
          arr[i] = Integer.parseInt(str[i]);
        }
        numbers.add(arr);
      }
      row++;
    }

    part1(numbers, ops);
    br.close();
  }
}
