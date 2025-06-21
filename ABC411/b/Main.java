package b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] D = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            D[i] = sc.nextInt();
        }

        int[] cumSum = new int[N];
        cumSum[0] = 0;
        for (int i = 1; i < N; i++) {
            cumSum[i] = cumSum[i - 1] + D[i - 1];
        }

        // 出力
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= N - i; j++) {
                int distance = cumSum[i + j - 1] - cumSum[i - 1];
                if (j > 1) {
                    System.out.print(" ");
                }
                System.out.print(distance);
            }
            System.out.println();
        }

        sc.close();
    }
}