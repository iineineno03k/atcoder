package d;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            String S = sc.next();

            int[] sum1 = new int[N + 1];
            for (int i = 0; i < N; i++) {
                sum1[i + 1] = sum1[i] + (S.charAt(i) == '1' ? 1 : 0);
            }

            int[] f = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                f[i] = i - 2 * sum1[i];
            }

            int minOps = sum1[N];
            int maxF = f[0];

            for (int r = 0; r <= N; r++) {
                int ops = sum1[N] + f[r] - maxF;
                minOps = Math.min(minOps, ops);

                maxF = Math.max(maxF, f[r]);
            }

            System.out.println(minOps);
        }

        sc.close();
    }
}