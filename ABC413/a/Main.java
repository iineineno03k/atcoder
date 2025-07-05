package ABC413.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            sum += A;
        }

        if (sum <= M) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        sc.close();
    }
}