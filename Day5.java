import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5 {

  static int freshness = 0;

  static void part1(List<long[]> freshIds, List<Long> id) {
    for (int i=0; i<id.size(); i++) {
      for (int j=0; j<freshIds.size(); j++) {
        long a = freshIds.get(j)[0];
        long b = freshIds.get(j)[1];

        long val = id.get(i);

        if (a <= val && val <= b) {
          freshness++; 
          break;
        }
      }

    }
  }

  static void part2(List<long[]> freshIds, List<Long> id) {
    
  }

  public static void main(String[] args) throws IOException {
    List<long[]> freshIds = new ArrayList<>();  
    List<Long> id = new ArrayList<>();
    // BufferedReader br = new BufferedReader(new FileReader("inputs/inputDay5Demo.txt"));
    BufferedReader br = new BufferedReader(new FileReader("inputs/inputDay5.txt"));
    String line = null;

    while ((line = br.readLine()) != null) {
      line = line.trim();
      if (line.isEmpty()) {
        continue;
      }
      String[] str = line.split("-");
      if (str.length > 1) {
        freshIds.add(new long[]{Long.parseLong(str[0]), Long.parseLong(str[1])});
      } else {
        id.add(Long.parseLong(str[0]));
      }
    }

    part1(freshIds, id);
    part2(freshIds, id);
    System.out.println("Part1 ans: " + freshness);

    br.close();
  }
}
