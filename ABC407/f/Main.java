package f;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] A = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            pairs.add(new Pair(A[i], i));
        }

        pairs.sort((a, b) -> {
            if (a.value != b.value) {
                return Long.compare(b.value, a.value); // 値は降順
            }
            return Integer.compare(a.index, b.index); // 添字は昇順
        });

        long[] integral0 = new long[N + 3];

        TreeSet<Integer> used = new TreeSet<>();
        used.add(-1);
        used.add(N);

        for (Pair pair : pairs) {
            long val = pair.value;
            int idx = pair.index;

            Integer rightBound = used.ceiling(idx);
            Integer leftBound = used.floor(idx);

            int L_i = idx - leftBound - 1;
            int R_i = rightBound - idx - 1;

            int xmin = Math.min(L_i, R_i);
            int xmax = Math.max(L_i, R_i);

            integral0[1] += val;

            if (1 + xmin + 1 < integral0.length) {
                integral0[1 + xmin + 1] -= val;
            }

            if (1 + xmax + 1 < integral0.length) {
                integral0[1 + xmax + 1] -= val;
            }

            if (1 + xmin + xmax + 2 < integral0.length) {
                integral0[1 + xmin + xmax + 2] += val;
            }

            used.add(idx);
        }

        long[] integral1 = new long[N + 3];
        integral1[0] = integral0[0];
        for (int i = 1; i < integral1.length; i++) {
            integral1[i] = integral1[i - 1] + integral0[i];
        }

        long[] integral2 = new long[N + 3];
        integral2[0] = integral1[0];
        for (int i = 1; i < integral2.length; i++) {
            integral2[i] = integral2[i - 1] + integral1[i];
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(integral2[i]);
        }

        sc.close();
    }

    static class Pair {
        long value;
        int index;

        Pair(long value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}