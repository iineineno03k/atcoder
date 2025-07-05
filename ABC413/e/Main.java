package ABC413.e;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int size = 1 << N;

            int[] P = new int[size];
            for (int i = 0; i < size; i++) {
                P[i] = sc.nextInt();
            }

            Set<String> visited = new HashSet<>();
            Queue<int[]> queue = new LinkedList<>();

            queue.add(P.clone());
            visited.add(Arrays.toString(P));

            int[] lexMin = P.clone();

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                if (isLexicographicallySmaller(current, lexMin)) {
                    lexMin = current.clone();
                }

                for (int b = 0; b <= N; b++) {
                    int blockSize = 1 << b;

                    for (int a = 0; a * blockSize < size; a++) {
                        int start = a * blockSize;
                        int end = Math.min(start + blockSize - 1, size - 1);

                        if (start <= end) {
                            int[] next = current.clone();
                            reverse(next, start, end);

                            String key = Arrays.toString(next);
                            if (!visited.contains(key)) {
                                visited.add(key);
                                queue.add(next);
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                if (i > 0)
                    System.out.print(" ");
                System.out.print(lexMin[i]);
            }
            System.out.println();
        }

        sc.close();
    }

    private static boolean isLexicographicallySmaller(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i])
                return true;
            if (a[i] > b[i])
                return false;
        }
        return false;
    }

    static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}