package e;

import java.util.*;

public class Main {
    static final long MOD = 998244353L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dice = new int[n][6];
        Set<Integer> uniqueValues = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                dice[i][j] = sc.nextInt();
                uniqueValues.add(dice[i][j]);
            }
            Arrays.sort(dice[i]);
        }

        List<Integer> values = new ArrayList<>(uniqueValues);

        long numerator = 0;
        long prevProd = 0;

        for (int val : values) {
            long prod = 1;
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < 6; j++) {
                    if (dice[i][j] <= val) {
                        count++;
                    }
                }
                prod = prod * count % MOD;
            }

            long diff = (prod - prevProd + MOD) % MOD;
            numerator = (numerator + (long) val * diff) % MOD;
            prevProd = prod;
        }

        long denominator = modPow(6, n, MOD);
        long answer = numerator * modInverse(denominator, MOD) % MOD;

        System.out.println(answer);
    }

    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    static long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }
}