package ABC344_toyota.d;

import java.util.*;

public class Main2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String T = scanner.nextLine();
    int N = Integer.parseInt(scanner.nextLine());
    List<List<String>> bags = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      String[] parts = scanner.nextLine().split(" ");
      List<String> bag = new ArrayList<>(Arrays.asList(parts).subList(1, parts.length));
      bags.add(bag);
    }

    System.out.println(minimumCost(T, bags));
  }

  private static int minimumCost(String T, List<List<String>> bags) {
    int[][] dp = new int[bags.size() + 1][T.length() + 1];
    for (int[] row : dp)
      Arrays.fill(row, Integer.MAX_VALUE / 2);
    dp[0][0] = 0;

    for (int i = 1; i <= bags.size(); i++) {
      for (int j = 0; j <= T.length(); j++) {
        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
        for (String s : bags.get(i - 1)) {
          if (j + s.length() <= T.length() && T.startsWith(s, j)) {
            dp[i][j + s.length()] = Math.min(dp[i][j + s.length()], dp[i - 1][j] + 1);
          }
        }
      }
    }

    return dp[bags.size()][T.length()] == Integer.MAX_VALUE / 2 ? -1 : dp[bags.size()][T.length()];
  }
}

