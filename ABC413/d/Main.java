package ABC413.d;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] tokens = br.readLine().split(" ");
            long[] A = new long[N];

            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(tokens[i]);
            }

            out.println(canFormGeometricSequence(N, A) ? "Yes" : "No");
        }

        out.close();
    }

    private static boolean canFormGeometricSequence(int n, long[] arr) {
        if (n == 2)
            return true;

        boolean allSame = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[0]) {
                allSame = false;
                break;
            }
        }
        if (allSame)
            return true;

        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (i != j && j != k && i != k) {
                            if (isValidTriplet(arr[i], arr[j], arr[k])) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }

        Map<Long, Integer> freq = new HashMap<>();
        for (long a : arr) {
            freq.put(a, freq.getOrDefault(a, 0) + 1);
        }

        List<Long> values = new ArrayList<>(freq.keySet());
        Collections.sort(values, (a, b) -> Long.compare(Math.abs(a), Math.abs(b)));

        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < values.size(); j++) {
                long first = values.get(i);
                long second = values.get(j);

                if (first == second && freq.get(first) < 2)
                    continue;

                if (trySequence(first, second, n, new HashMap<>(freq))) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isValidTriplet(long a, long b, long c) {
        return b * b == a * c;
    }

    private static boolean trySequence(long first, long second, int n, Map<Long, Integer> freq) {
        List<Long> sequence = new ArrayList<>();
        sequence.add(first);
        sequence.add(second);

        freq.put(first, freq.get(first) - 1);
        if (freq.get(first) == 0)
            freq.remove(first);

        if (!freq.containsKey(second))
            return false;
        freq.put(second, freq.get(second) - 1);
        if (freq.get(second) == 0)
            freq.remove(second);

        while (sequence.size() < n) {
            int size = sequence.size();
            long prev = sequence.get(size - 2);
            long curr = sequence.get(size - 1);

            if (prev == 0)
                return false;

            long next;
            try {
                long g = gcd(Math.abs(curr), Math.abs(prev));
                long currReduced = curr / g;
                long prevReduced = prev / g;

                if (Math.abs(currReduced) > Long.MAX_VALUE / Math.abs(curr)) {
                    return false;
                }

                long product = currReduced * curr;
                if (product % prevReduced != 0) {
                    return false;
                }

                next = product / prevReduced;
            } catch (ArithmeticException e) {
                return false;
            }

            if (!freq.containsKey(next))
                return false;

            sequence.add(next);
            freq.put(next, freq.get(next) - 1);
            if (freq.get(next) == 0)
                freq.remove(next);
        }

        return freq.isEmpty();
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}