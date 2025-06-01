package c;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] diff = new int[N + 2];

        for (int i = 0; i < M; i++) {
            int L = sc.nextInt();
            int R = sc.nextInt();

            diff[L]++;
            diff[R + 1]--;
        }

        int count = 0;
        int minGuards = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            count += diff[i];
            minGuards = Math.min(minGuards, count);
        }

        System.out.println(minGuards);
        sc.close();
    }
}