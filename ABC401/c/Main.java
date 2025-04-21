package ABC401.c;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int K = scanner.nextInt();
    
    long[] dp = new long[N+1];
    for(int i = 0; i < Math.min(K, N+1); i++) {
        // K-1番目までは1とする
        dp[i] = 1;
    }
    
    // K-1番目までの合計を計算
    long sum = 0;
    for (int i = 0; i < Math.min(K, N+1); i++) {
        sum = (sum + dp[i]) % 1_000_000_000;
    }

    // K番目以降を計算
    for (int i = K; i <= N; i++) {
        dp[i] = sum;
        sum = (sum - dp[i-K] + dp[i]) % 1_000_000_000;
        if (sum < 0) {
            sum += 1_000_000_000;
        }
    }

    System.out.println(dp[N]);
    scanner.close();
  }
}