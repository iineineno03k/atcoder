package ABC302_toyota.d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // AとBの総当たりで差を絶対値取る→TLE

        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int M = Integer.parseInt(sc.next());
        long D = Long.parseLong(sc.next());

        List<Long> A = new ArrayList<>();
        List<Long> B = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(Long.parseLong(sc.next()));
        }

        for (int i = 0; i < M; i++) {
            B.add(Long.parseLong(sc.next()));
        }
        sc.close();

        Collections.sort(A);
        Collections.sort(B);

        while (true) {

            if (N == 0 || M == 0) {
                System.out.println(-1);
                break;
            }

            long a = A.get(N - 1);
            long b = B.get(M - 1);

            if (Math.abs(a - b) <= D) {
                System.out.println(a + b);
                break;
            }

            if (a > b) {
                A.remove(N - 1);
                N--;
            } else {
                B.remove(M - 1);
                M--;
            }

        }

    }
}
