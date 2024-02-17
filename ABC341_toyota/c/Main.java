package ABC341_toyota.c;

import java.util.Scanner;

public class Main {

  private static final int[] dx = {-1, 1, 0, 0}; // U, D, L, R のy方向移動
  private static final int[] dy = {0, 0, -1, 1}; // U, D, L, R のx方向移動
  private static char[][] grid;
  private static int H, W;
  private static String T;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    H = scanner.nextInt();
    W = scanner.nextInt();
    int N = scanner.nextInt();
    T = scanner.next();
    grid = new char[H][W];

    for (int i = 0; i < H; i++) {
      String line = scanner.next();
      for (int j = 0; j < W; j++) {
        grid[i][j] = line.charAt(j);
      }
    }

    int possibleStarts = 0;
    for (int i = 1; i < H - 1; i++) {
      for (int j = 1; j < W - 1; j++) {
        if (grid[i][j] == '.' && canReach(i, j, N)) {
          possibleStarts++;
        }
      }
    }

    System.out.println(possibleStarts);
  }

  private static boolean canReach(int x, int y, int N) {
    for (int i = 0; i < N; i++) {
      char move = T.charAt(i);
      int dirIndex = "UDLR".indexOf(move);
      x += dx[dirIndex];
      y += dy[dirIndex];

      if (x < 0 || x >= H || y < 0 || y >= W || grid[x][y] == '#') {
        return false;
      }
    }
    return true;
  }
}

