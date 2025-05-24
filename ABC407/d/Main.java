package d;

import java.util.Scanner;

public class Main {
    static int H, W;
    static long[][] A;
    static boolean[][] covered;
    static long maxScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        A = new long[H][W];
        covered = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = sc.nextLong();
            }
        }
        sc.close();

        dfs(0, 0);
        System.out.println(maxScore);
    }

    static void dfs(int row, int col) {
        if (row == H) {
            long score = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (!covered[i][j]) {
                        score ^= A[i][j];
                    }
                }
            }
            maxScore = Math.max(maxScore, score);
            return;
        }

        int nextRow = col + 1 < W ? row : row + 1;
        int nextCol = col + 1 < W ? col + 1 : 0;

        if (covered[row][col]) {
            dfs(nextRow, nextCol);
            return;
        }

        dfs(nextRow, nextCol);

        if (col + 1 < W && !covered[row][col + 1]) {
            covered[row][col] = true;
            covered[row][col + 1] = true;
            dfs(nextRow, nextCol);
            covered[row][col] = false;
            covered[row][col + 1] = false;
        }

        if (row + 1 < H && !covered[row + 1][col]) {
            covered[row][col] = true;
            covered[row + 1][col] = true;
            dfs(nextRow, nextCol);
            covered[row][col] = false;
            covered[row + 1][col] = false;
        }
    }
}