package ABC305_kyosera.d;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] sleepTime = new long[N / 2 + 1];
        long[] awakeTime = new long[N / 2 + 1];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                awakeTime[i / 2] = sc.nextLong();
            } else {
                sleepTime[i / 2] = sc.nextLong();
            }
        }

        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            long l = sc.nextLong();
            long r = sc.nextLong();

            // 睡眠時間と覚醒時間の境界を二分探索
            int sleepIndex = Arrays.binarySearch(sleepTime, l);
            int awakeIndex = Arrays.binarySearch(awakeTime, r);

            if (sleepIndex < 0) {
                sleepIndex = -(sleepIndex + 1);
            }
            if (awakeIndex < 0) {
                awakeIndex = -(awakeIndex + 1) - 1;
            }

            long totalSleepTime = (awakeIndex >= sleepIndex) ? awakeTime[awakeIndex] - sleepTime[sleepIndex] : 0;
            if (r < awakeTime[awakeIndex]) {
                totalSleepTime -= awakeTime[awakeIndex] - r;
            }
            if (l > sleepTime[sleepIndex]) {
                totalSleepTime -= l - sleepTime[sleepIndex];
            }

            System.out.println(totalSleepTime);
        }

        sc.close();
    }
}
