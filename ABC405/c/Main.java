package c;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
        }

        long sum = 0;
        long sumOfSquares = 0;

        for (int i = 0; i < N; i++) {
            sum += A[i];
            sumOfSquares += A[i] * A[i];
        }

        long result = (sum * sum - sumOfSquares) / 2;

        System.out.println(result);
        scanner.close();
    }
}
