package ABC309_denso.b;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] arr = sc.next().toCharArray();
            for (int j = 0; j < N; j++) {
                grid[i][j] = arr[j] - '0';
            }
        }
        sc.close();

        int[][] newGrid = new int[N][N];
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                newGrid[i][j] = grid[i][j];
            }
        }

        int[] topRow = new int[N];
        int[] bottomRow = new int[N];
        int[] leftColumn = new int[N];
        int[] rightColumn = new int[N];

        // Copy the border cells to temporary arrays
        for (int i = 0; i < N; i++) {
            topRow[i] = grid[0][i];
            bottomRow[i] = grid[N-1][i];
            leftColumn[i] = grid[i][0];
            rightColumn[i] = grid[i][N-1];
        }

        // Fill the border of the new grid
        for (int i = 0; i < N; i++) {
            if(i != 0) newGrid[0][i] = topRow[i-1];
            if(i != N-1) newGrid[N-1][i] = bottomRow[i+1];
            if(i != N-1) newGrid[i][0] = leftColumn[i+1];
            if(i != 0) newGrid[i][N-1] = rightColumn[i-1];
        }

        newGrid[0][0] = leftColumn[1];
        newGrid[N-1][0] = bottomRow[0];
        newGrid[N-1][N-1] = rightColumn[N-2];
        newGrid[0][N-1] = topRow[0];

        // Print the result
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(newGrid[i][j]);
            }
            System.out.println();
        }
    }
}
