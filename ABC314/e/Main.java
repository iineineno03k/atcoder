package ABC314.e;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] C = new int[N];
        int[][] S = new int[N][];
        double[][] prob = new double[N][M + 1];

        for (int i = 0; i < N; i++) {
            C[i] = sc.nextInt();
            int P = sc.nextInt();
            S[i] = new int[P];
            
            for (int j = 0; j < P; j++) {
                S[i][j] = sc.nextInt();
            }
            
            for (int j = 0; j < P; j++) {
                if (S[i][j] <= M) {
                    prob[i][S[i][j]] += 1.0 / P;
                }
            }
        }

        double[] dp = new double[M + 1];
        for (int x = M - 1; x >= 0; x--) {
            double minExpectedCost = Double.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                double expectedCost = C[i];
                for (int y = 0; y <= M; y++) {
                    if (x + y <= M) {
                        expectedCost += dp[x + y] * prob[i][y];
                    }
                }
                minExpectedCost = Math.min(minExpectedCost, expectedCost);
            }
            dp[x] = minExpectedCost;
        }

        System.out.printf("%.15f%n", dp[0]);
    }
}
