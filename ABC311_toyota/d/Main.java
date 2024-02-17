package ABC311_toyota.d;

import java.util.*;

public class Main {
    static int N, M;
    static char[][] grid;
    static boolean[][] visited;
    static boolean[][] dfsStarted;

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        grid = new char[N][M];
        visited = new boolean[N][M];
        dfsStarted = new boolean[N][M];

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
        if (dfsStarted[x][y]) {
            return;
        }

        dfsStarted[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x, ny = y;

            while (true) {
                nx += dx[i];
                ny += dy[i];

                if (grid[nx][ny] == '#') {
                    break;
                }

                visited[nx][ny] = true;
            }

            dfs(nx - dx[i], ny - dy[i]);
        }
    }

}
