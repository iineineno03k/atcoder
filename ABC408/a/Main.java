package a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] T = new int[N];
        for (int i = 0; i < N; i++) {
            T[i] = sc.nextInt();
        }

        // 最初に肩を叩く時刻は0
        int lastTime = 0;
        boolean awake = true;

        for (int i = 0; i < N; i++) {
            int interval = T[i] - lastTime;

            if (interval * 2 > 2 * S + 1) {
                awake = false;
                break;
            }

            lastTime = T[i];
        }

        if (awake) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        sc.close();
    }
}