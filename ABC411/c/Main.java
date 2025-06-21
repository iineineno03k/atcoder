package c;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();

        boolean[] black = new boolean[N + 2];
        int segments = 0;

        for (int i = 0; i < Q; i++) {
            int A = sc.nextInt();

            boolean leftBlack = black[A - 1];
            boolean rightBlack = black[A + 1];
            boolean currentBlack = black[A];

            if (!currentBlack) {
                black[A] = true;

                if (!leftBlack && !rightBlack) {
                    segments++;
                } else if (leftBlack && rightBlack) {
                    segments--;
                }

            } else {
                black[A] = false;

                if (!leftBlack && !rightBlack) {
                    segments--;
                } else if (leftBlack && rightBlack) {
                    segments++;
                }
            }

            System.out.println(segments);
        }

        sc.close();
    }
}