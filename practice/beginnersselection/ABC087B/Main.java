package practice.beginnersselection.ABC087B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 500円玉
        int a = Integer.parseInt(sc.next());
        // 100円玉
        int b = Integer.parseInt(sc.next());
        // 50円玉
        int c = Integer.parseInt(sc.next());

        int x = Integer.parseInt(sc.next());

        int count = 0;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                for (int k = 0; k <= c; k++) {
                    if (500 * i + 100 * j + 50 * k == x) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

        sc.close();
    }
}
