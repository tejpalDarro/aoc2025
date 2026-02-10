import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Day2 {

  static List<String> part2List = new ArrayList<>();

  public static void checkSizes(String s) {
    int n = s.length();

    for (int size=1; size<=n/2; size++) {
      if (n % size!= 0) continue;

      String pattern = s.substring(0, size);
      boolean allSame = true;

      for (int i=size; i<n; i+=size) {
        String part = s.substring(i,i+size);
        if (!part.equals(pattern)) {
          allSame = false;
          break;
        }
      }

      if (allSame) {
        part2List.add(s);
        // System.out.println(
        //     "size= " + size + " repeats: " + pattern + " value: " + s
        //     );
        break;
      }
    }
  }

  public static void part2() throws IOException {
    // BufferedReader br = new BufferedReader(new FileReader("inputs/inputDay2Demo.txt"));
    BufferedReader br = new BufferedReader(new FileReader("inputs/inputDay2.txt"));
    String line = null;
    List<String> list = new ArrayList<>();
    List<String> invalid = new ArrayList<>();

    while ((line = br.readLine()) != null) {
      String[] str = line.split(",");
      list.addAll(Arrays.asList(str));
    }

    for (String s : list) {
      String[] split = s.split("-");
      long a = Long.parseLong(split[0]);
      long b = Long.parseLong(split[1]);
      for (long i=a; i<=b; i++) {
        String ex = String.valueOf(i);
        checkSizes(ex);
      }
    }

    long total = 0;
    for (String s : part2List) {
      // System.out.println(s);
      total = Long.parseLong(s) + total;
    }
    System.out.println("Part2 Total: " + total);
    br.close();
  }
  public static void part1() throws IOException{
    // BufferedReader br = new BufferedReader(new FileReader("inputDay2Demo.txt"));
    BufferedReader br = new BufferedReader(new FileReader("inputDay2.txt"));
    String line = null;
    List<String> list = new ArrayList<>();
    List<String> invalid = new ArrayList<>();

    while ((line = br.readLine()) != null) {
      String[] str = line.split(",");
      list.addAll(Arrays.asList(str));
    }

    for (String s : list) {
      // System.out.println(s + ": ");
      String[] split = s.split("-");
      long a = Long.parseLong(split[0]);
      long b = Long.parseLong(split[1]);
      for (long i=a; i<=b; i++) {
        long digits = String.valueOf(i).length();
        if (digits % 2 == 0) {
          String str = String.valueOf(i);
          int spt = (int)digits/2;
          String start = str.substring(0, spt);
          String end = str.substring(spt);
          if (start.equals(end)) {
            invalid.add(str);
          }
          // System.out.print("- Start: " + start + ", End: " + end + " - ");
          // System.out.print(i + " ");

        } else {
          // System.out.print(" Odd: " + i + " ");
        }
      }
     // System.out.println(); 
    }
    long total = 0;
    for (String s : invalid) {
      // System.out.println(s);
      total = Long.parseLong(s) + total;
    }
    System.out.println("Part1 Total: " + total);
    br.close();
  }

  public static void main(String[] args) throws IOException {
    part1();
    part2();
  }  
}
