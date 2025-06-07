package g;

import java.util.Scanner;

public class Main {
    static final long MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int P = sc.nextInt();

        long p = P * pow(100, MOD - 2) % MOD;
        long q = (100 - P) * pow(100, MOD - 2) % MOD;

        long[][] dp = new long[N][N + 1];
        dp[0][1] = 1;

        for (int i = 1; i < N; i++) {
            // 前回の状態をコピー
            for (int k = 1; k <= N; k++) {
                dp[i][k] = dp[i - 1][k];
            }

            // 操作1: 確率pで新しい値(i+1)を追加
            dp[i][i + 1] = (dp[i][i + 1] + p) % MOD;

            // 操作2: 確率qで1以上(i+1)-1=i以下の値から選択
            // 各値kが選ばれる確率 = q * dp[i-1][k] / Σ(j=1 to i) dp[i-1][j]
            
            // まず1からiまでの総個数を計算
            long totalCount = 0;
            for (int k = 1; k <= i; k++) {
                totalCount = (totalCount + dp[i - 1][k]) % MOD;
            }
            
            if (totalCount > 0) {
                long invTotal = pow(totalCount, MOD - 2);
                
                for (int k = 1; k <= i; k++) {
                    if (dp[i - 1][k] > 0) {
                        long selectProb = q * dp[i - 1][k] % MOD * invTotal % MOD;
                        dp[i][k] = (dp[i][k] + selectProb) % MOD;
                    }
                }
            }
        }

        for (int k = 1; k <= N; k++) {
            System.out.println(dp[N - 1][k]);
        }

        sc.close();
    }

    static long pow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp /= 2;
        }
        return result;
    }
}