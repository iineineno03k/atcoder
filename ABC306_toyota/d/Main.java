package ABC306_toyota.d;

import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE / 2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dishes = new long[n+1][2];
        for (int i = 1; i <= n; i++) {
            String[] line = br.readLine().split(" ");
            dishes[i][0] = Integer.parseInt(line[0]);
            dishes[i][1] = Long.parseLong(line[1]);
        }
        Arrays.sort(dishes, (a, b) -> (a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(b[1], a[1])));
        long[][] dp = new long[n+1][n+1];
        for (long[] row : dp) Arrays.fill(row, -INF);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j < i) dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                if (j > 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + dishes[i][1]);
            }
        }
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            ans = Math.max(ans, dp[n][i]);
        }
        System.out.println(ans);
    }
}
