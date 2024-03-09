package ABC344_toyota.d;

import java.util.Arrays;
import java.util.Scanner;

/** 不正解. */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String T = scanner.next();
    int N = scanner.nextInt();
    int[] dp = new int[T.length() + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i = 0; i < N; i++) {
      int A = scanner.nextInt();
      for (int j = 0; j < A; j++) {
        String S = scanner.next();
        for (int k = 0; k <= T.length(); k++) {
          if (dp[k] != Integer.MAX_VALUE && k + S.length() <= T.length() && T.startsWith(S, k)) {
            dp[k + S.length()] = Math.min(dp[k + S.length()], dp[k] + 1);
          }
        }
      }
    }

    System.out.println(dp[T.length()] == Integer.MAX_VALUE ? -1 : dp[T.length()]);
  }
}
