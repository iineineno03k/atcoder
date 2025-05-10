package b;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < N; i++) {
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
        }

        boolean allNumbersExist = true;
        for (int i = 1; i <= M; i++) {
            if (!count.containsKey(i) || count.get(i) == 0) {
                allNumbersExist = false;
                break;
            }
        }

        if (!allNumbersExist) {
            System.out.println(0);
            scanner.close();
            return;
        }

        int operations = 0;
        for (int i = N - 1; i >= 0; i--) {
            int num = A[i];
            count.put(num, count.get(num) - 1);
            operations++;

            if (count.get(num) == 0 && num <= M) {
                break;
            }
        }

        System.out.println(operations);
        scanner.close();
    }
}
