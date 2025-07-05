package ABC413.c;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt();

        ArrayDeque<long[]> deque = new ArrayDeque<>();

        for (int i = 0; i < Q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                long c = sc.nextLong();
                long x = sc.nextLong();
                deque.addLast(new long[] { x, c });
            } else {
                long k = sc.nextLong();
                long sum = 0;

                while (k > 0) {
                    long[] front = deque.peekFirst();
                    long value = front[0];
                    long count = front[1];

                    if (k >= count) {
                        sum += value * count;
                        k -= count;
                        deque.pollFirst();
                    } else {
                        sum += value * k;
                        front[1] -= k;
                        k = 0;
                    }
                }

                System.out.println(sum);
            }
        }

        sc.close();
    }
}