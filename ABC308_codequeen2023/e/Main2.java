package ABC308_codequeen2023.e;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        int[] A = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String S = scanner.nextLine();
        scanner.close();

        long ans = 0;
        int latestM = -1, latestE = -1, latestX = -1;
        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            if (c == 'M') {
                latestM = i;
            } else if (c == 'E') {
                latestE = i;
            } else if (c == 'X') {
                latestX = i;
            }
            if (latestM > latestE && latestE > latestX) {
                int mex = mex(A[latestM], A[latestE], A[latestX]);
                ans += mex;
            }
        }

        System.out.println(ans);
    }

    private static int mex(int a, int b, int c) {
        for (int i = 0; i <= 2; i++) {
            if (i != a && i != b && i != c) {
                return i;
            }
        }
        return -1; // ここに到達することはありません
    }
}
