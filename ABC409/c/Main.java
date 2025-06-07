package c;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();

        int[] pos = new int[N];
        pos[0] = 0;

        for (int i = 1; i < N; i++) {
            int d = sc.nextInt();
            pos[i] = (pos[i - 1] + d) % L;
        }

        if (L % 3 != 0) {
            System.out.println(0);
            sc.close();
            return;
        }

        int unit = L / 3;

        Map<Integer, Integer> posCount = new HashMap<>();
        for (int i = 0; i < N; i++) {
            posCount.put(pos[i], posCount.getOrDefault(pos[i], 0) + 1);
        }

        long count = 0;

        for (Map.Entry<Integer, Integer> entry : posCount.entrySet()) {
            int p = entry.getKey();
            int cnt1 = entry.getValue();

            int p2 = (p + unit) % L;
            int p3 = (p + 2 * unit) % L;

            int cnt2 = posCount.getOrDefault(p2, 0);
            int cnt3 = posCount.getOrDefault(p3, 0);

            if (p != p2 && p2 != p3 && p3 != p) {
                count += (long) cnt1 * cnt2 * cnt3;
            } else if (p == p2 && p2 == p3) {
                if (cnt1 >= 3) {
                    count += (long) cnt1 * (cnt1 - 1) * (cnt1 - 2) / 6;
                }
            }
        }

        count /= 3;

        System.out.println(count);
        sc.close();
    }
}