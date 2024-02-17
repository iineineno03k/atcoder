package ABC313_senshuken.c;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] A = new long[N];
        long sum = 0;

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextLong();
            sum += A[i];
        }

        long avg = sum / N;
        long operations = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] < avg) {
                operations += Math.abs(A[i] - avg);
            } else {
                operations += Math.abs(A[i] - (avg + 1));
            }
        }
        double result = Math.ceil((double)operations / 2);

        System.out.println((int) result);
    }
}
