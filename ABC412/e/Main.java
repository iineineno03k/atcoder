package ABC412.e;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long L = sc.nextLong();
        long R = sc.nextLong();

        System.out.println(countDistinctLCM(L, R));
        sc.close();
    }

    static long countDistinctLCM(long L, long R) {
        long count = 0;

        count += countPrimesSegmentedSieve(L + 1, R);
        count += countPrimePowersEfficient(L + 1, R);

        return count + 1;
    }

    static long countPrimesSegmentedSieve(long left, long right) {
        if (right < 2)
            return 0;
        if (left <= 1)
            left = 2;

        long count = 0;
        if (left <= 2 && right >= 2) {
            count = 1;
            left = 3;
        }

        if (left > right)
            return count;

        int sqrtR = (int) Math.sqrt(right) + 1;
        List<Integer> basePrimes = sievePrimesUpTo(sqrtR);

        int segmentSize = Math.max(sqrtR, 1 << 15);

        for (long low = left; low <= right; low += segmentSize) {
            long high = Math.min(low + segmentSize - 1, right);
            boolean[] isPrime = new boolean[(int) (high - low + 1)];
            Arrays.fill(isPrime, true);

            for (long i = low + (low % 2 == 0 ? 0 : 1); i <= high; i += 2) {
                isPrime[(int) (i - low)] = false;
            }

            for (int p : basePrimes) {
                if (p == 2)
                    continue;

                long start = ((low + p - 1) / p) * p;
                if (start == p)
                    start = p * (long) p;

                for (long j = start; j <= high; j += p) {
                    isPrime[(int) (j - low)] = false;
                }
            }

            for (long i = low; i <= high; i++) {
                if (isPrime[(int) (i - low)])
                    count++;
            }
        }

        return count;
    }

    static List<Integer> sievePrimesUpTo(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i])
                primes.add(i);
        }

        return primes;
    }

    static long countPrimePowersEfficient(long left, long right) {
        long count = 0;

        int maxP = (int) Math.sqrt(right) + 1;
        List<Integer> primes = sievePrimesUpTo(maxP);

        for (int p : primes) {
            long pk = (long) p * p;

            while (pk <= right) {
                if (pk >= left)
                    count++;

                if (pk > right / p)
                    break;
                pk *= p;
            }
        }

        return count;
    }
}