package b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int count = 0;
        for (int a = 1; a <= 6; a++) {
            for (int b = 1; b <= 6; b++) {
                if (a + b >= X || Math.abs(a - b) >= Y) {
                    count++;
                }
            }
        }
        double ans = (double) count / 36.0;
        System.out.println(ans);
        sc.close();
    }
}