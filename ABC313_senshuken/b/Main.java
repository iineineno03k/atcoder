package ABC313_senshuken.b;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 強さの関係を保存するための行列を初期化
        boolean[][] isStronger = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt() - 1;
            int B = sc.nextInt() - 1;
            isStronger[A][B] = true;
        }

        // 推移律を反映させる
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (isStronger[i][k] && isStronger[k][j]) {
                        isStronger[i][j] = true;
                    }
                }
            }
        }

        int strongestProgrammer = -1;
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i != j && isStronger[i][j]) {
                    count++;
                }
            }

            if (count == N - 1) {
                if (strongestProgrammer != -1) {
                    strongestProgrammer = -1;
                    break;
                }
                strongestProgrammer = i + 1;
            }
        }

        System.out.println(strongestProgrammer);
    }
}
