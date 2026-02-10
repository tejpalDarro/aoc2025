import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Day4 {

  static final int[] DIR_X = {0,1,0,-1,1,1,-1,-1};
  static final int[] DIR_Y = {1,0,-1,0,1,-1,1,-1};
  static int part1Ans = 0;
  static int part2Ans = 0;

  static void part1(List<List<Character>> list) {
    for ( int i = 0; i < list.size(); i++ ) {
      for ( int j = 0; j < list.get(i).size(); j++ ) {
        if (list.get(i).get(j) == '@') {
          boolean flag = checkBoundry(list, i, j);
          if (flag) {
            list.get(i).set(j,'@');
            part1Ans++;
          }
        }
      }
    }  
    System.out.println("Part1 ans: " + part1Ans);
  }

  static void part2(List<List<Character>> list) {
    int tot = 0;

    while (true) {
      List<int[]> toRemove = new ArrayList<>();
      tot = 0;
      for ( int i = 0; i < list.size(); i++ ) {
        for ( int j = 0; j < list.get(i).size(); j++ ) {
          if (list.get(i).get(j) == '@') {
            boolean flag = checkBoundry(list, i, j);
            if (flag) {
              toRemove.add(new int[]{i,j});
              tot++;
            }
          }
        }
      }  
      // System.out.println("Remove " + tot + " rools of paper:");
      part2Ans += tot;

      if (tot == 0) break;

      for (int[] a : toRemove) {
        list.get(a[0]).set(a[1], '.');
      }
    }
    System.out.println("Part2 ans: " + part2Ans);
  }

  static boolean checkBoundry(List<List<Character>> list, int a, int b) {
    int cnt = 0;
    
    for (int dir=0; dir<8; dir++) {
     
      int ni = a + DIR_X[dir];
      int nj = b + DIR_Y[dir];

      if (ni >= 0 && ni < list.size() && nj >= 0 && nj < list.get(ni).size()) {
        if (list.get(ni).get(nj) == '@') {
          cnt++;
        }
      }

    }
    return cnt < 4;
  }

  public static void main(String[] args) throws IOException {
    List<List<Character>> arr = new ArrayList<>();
    // BufferedReader br = new BufferedReader(new FileReader("inputs/inputDay4Demo.txt"));
    BufferedReader br = new BufferedReader(new FileReader("inputs/inputDay4.txt"));
    String line = null;

    while ((line = br.readLine()) != null ) {
      List<Character> ac = new ArrayList<>();
      char[] charArray = line.toCharArray();
      for (char a : charArray) {
        ac.add(a);
      }
      arr.add(ac);
    }
    part1(arr);
    part2(arr);
    br.close();
  }
}
