package f;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[M + 1];
        int[] B = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int q = 1; q <= Q; q++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            int clockwiseCrosses = 0;
            int counterclockwiseCrosses = 0;

            for (int i = 1; i <= M; i++) {
                int a = A[i];
                int b = B[i];

                boolean aOnClockwise = isPointOnPath(N, C, D, a, true);
                boolean bOnClockwise = isPointOnPath(N, C, D, b, true);
                if ((aOnClockwise && !bOnClockwise) || (!aOnClockwise && bOnClockwise)) {
                    clockwiseCrosses++;
                }

                boolean aOnCounterclockwise = isPointOnPath(N, C, D, a, false);
                boolean bOnCounterclockwise = isPointOnPath(N, C, D, b, false);
                if ((aOnCounterclockwise && !bOnCounterclockwise) || (!aOnCounterclockwise && bOnCounterclockwise)) {
                    counterclockwiseCrosses++;
                }
            }

            sb.append(Math.min(clockwiseCrosses, counterclockwiseCrosses)).append('\n');
        }

        System.out.print(sb);
    }

    private static boolean isPointOnPath(int N, int C, int D, int p, boolean isClockwise) {
        if (C == p || D == p) {
            return true;
        }

        if (isClockwise) {
            if (C < D) {
                return C < p && p < D;
            } else {
                return p > C || p < D;
            }
        } else {
            if (C > D) {
                return D < p && p < C;
            } else {
                return p < C || p > D;
            }
        }
    }
}