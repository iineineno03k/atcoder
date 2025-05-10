package g;

import java.io.*;
import java.util.*;

public class Main {
    private static final int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer>[] prefixCount = new HashMap[N + 1];
        for (int i = 0; i <= N; i++) {
            prefixCount[i] = new HashMap<>();
        }

        for (int i = 1; i <= N; i++) {
            prefixCount[i].putAll(prefixCount[i - 1]);
            int value = A[i];
            prefixCount[i].put(value, prefixCount[i].getOrDefault(value, 0) + 1);
        }

        long[] fact = new long[N + 1];
        long[] invFact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[N] = modPow(fact[N], MOD - 2, MOD);
        for (int i = N - 1; i >= 0; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> rangeCount = new HashMap<>();
            int totalElements = 0;

            for (Map.Entry<Integer, Integer> entry : prefixCount[R].entrySet()) {
                int value = entry.getKey();
                if (value < X) {
                    int countR = entry.getValue();
                    int countL = prefixCount[L - 1].getOrDefault(value, 0);
                    int count = countR - countL;
                    if (count > 0) {
                        rangeCount.put(value, count);
                        totalElements += count;
                    }
                }
            }

            if (totalElements == 0) {
                sb.append(1).append("\n");
                continue;
            }

            long result = fact[totalElements];
            for (int count : rangeCount.values()) {
                result = (result * invFact[count]) % MOD;
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    private static long modPow(long base, int exponent, int mod) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent >>= 1;
        }
        return result;
    }
}
