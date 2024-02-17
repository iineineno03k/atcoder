package ABC311_toyota.a;

import java.util.*;

public class Main {
    static int N, M;
    static char[][] grid;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};  // 上下左右への移動を表す
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();  // 改行を読み飛ばす

        grid = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        dfs(1, 1);

        int iceCount = 0;
        for (boolean[] row : visited) {
            for (boolean cell : row) {
                if (cell) {
                    iceCount++;
                }
            }
        }

        System.out.println(iceCount);
    }

    static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M || grid[x][y] == '#' || visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }
}
