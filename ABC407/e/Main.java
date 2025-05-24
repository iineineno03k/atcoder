package e;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            long[] A = new long[2 * N];
            for (int i = 0; i < 2 * N; i++) {
                A[i] = Long.parseLong(br.readLine());
            }

            PriorityQueue<Long> canChangeToOpen = new PriorityQueue<>(Collections.reverseOrder());

            long score = 0;
            int balance = 0;

            for (int i = 0; i < 2 * N; i++) {
                balance--;
                canChangeToOpen.offer(A[i]);

                if (balance < 0) {
                    long value = canChangeToOpen.poll();
                    score += value;
                    balance += 2;
                }
            }

            int currentOpenCount = (2 * N + balance) / 2;

            while (currentOpenCount < N) {
                long value = canChangeToOpen.poll();
                score += value;
                currentOpenCount++;
            }

            out.println(score);
        }

        out.flush();
        out.close();
        br.close();
    }
}