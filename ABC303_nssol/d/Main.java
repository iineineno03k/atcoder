package ABC303_nssol.d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = br.readLine().split(" ");
        int x = Integer.parseInt(sa[0]);
        int y = Integer.parseInt(sa[1]);
        int z = Integer.parseInt(sa[2]);
        char[] s = br.readLine().toCharArray();
        br.close();

        int n = s.length;
        long[][] dp = new long[n + 1][2];
        dp[0][1] = z;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') {
                dp[i + 1][0] = Math.min(dp[i][0] + x, dp[i][1] + z + x);
                dp[i + 1][1] = Math.min(dp[i][1] + y, dp[i][0] + z + y);
            } else {
                dp[i + 1][1] = Math.min(dp[i][1] + x, dp[i][0] + z + x);
                dp[i + 1][0] = Math.min(dp[i][0] + y, dp[i][1] + z + y);
            }
        }
        long ans = Math.min(dp[n][0], dp[n][1]);
        System.out.println(ans);
        // 動的計画法（DP）
        // dp0 = CapsLockがoff
        // dp1 = CapsLockがon

        // dp1[1] = dp1[0]+1,dp0[0]+3+1
        // dp0[1] = dp0[0]+3,dp1[0]+3+3

        // AAaA
        // 1,3,3

        // dp0={0,3,6,7,10}
        // dp1={3,4,5,8,9}

        // 0 A a a A A a 文字
        // dpCaps無 0
        // dpCaps有 z

    }
}
