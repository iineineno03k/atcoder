package g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        int[] A = new int[N];
        int[] B = new int[M];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i + 1]);
        }
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(input[i + N + 1]);
        }
        int[] C = new int[N + M];
        for (int i = 0; i < N + M; i++) {
            C[i] = A[i] + B[i];
        }
        Arrays.sort(C);
        int ans = 0;
        for (int i = 0; i < N + M; i++) {
            if (C[i] <= K) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}